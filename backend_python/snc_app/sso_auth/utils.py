from dataclasses import dataclass
from typing import Type, TypeVar
from keycloak.exceptions import KeycloakAuthenticationError, KeycloakError
import jwt
T = TypeVar("T")  # Tipo genérico

def decode_generic_token(token:str,**args)->dict:
    
    return jwt.decode(token, 
                    **args)


class GetGeneralTokenInfo:
    def __init__(self,token:str)->None:
        self._token = token

    def decode_token(self,**args):
        if not args:
            args = {"options":{
                    "verify_signature": False
            }}

        self._decoded_token=decode_generic_token(self._token, 
                                                 **args)
    def extract_user(self, default_keys=[]):
        extracted_user={}
        if not len(default_keys):
            default_keys=[
                "name",
                "account",
                "preferred_username",
                "given_name",
                "realm_access",
                "email"


            ]
        print(self._decoded_token)
        for key in default_keys:
            if self._decoded_token.get(key):
                extracted_user[key] =self._decoded_token.get(key)
        return extracted_user     
       
    def decode_and_get_user(self,**args):
        self.decode_token(**args)
        user_info=self.extract_user([])
        return user_info
    
@dataclass
class SSOAuth:
    
    url:str=""
    client_id:str=""
    client_secret:str=""
    client_scope:str=""
    realm_name:str=""
    redirect_uri:str=""


    def _serialize_attr(self):
        return {
              "server_url":self.url,
              "client_id":self.client_id,
              "realm_name":self.realm_name,
              "client_secret_key":self.client_secret
        }
    def instance_openid_manager(self, objectController:Type[T])->None:
        """initialize manager connector"""
        if not objectController:
            raise ValueError("Clase controladora de keycloak no existente")

        params = self._serialize_attr()
        self.__handler= objectController(
            **params
        )

    def auth_by_password(self,username:str,password)->dict:
        if not self.__handler:
            raise ValueError("Controlador keycloak no instanciado")
        try:
            token = self.__handler.token(username, password)
        except KeycloakAuthenticationError as e:
            raise ValueError("Error de autenticacion")
        except KeycloakError as e:
            raise ValueError("Error de comunicacion")
        return token

    def logout(self,token:str)->dict:
        if not self.__handler:
            raise ValueError("Controlador keycloak no instanciado")
        
        try:
             token = self.__handler.logout(token)
        except KeycloakAuthenticationError as e:
            raise ValueError("Error de autenticacion")
        except KeycloakError as e:
            raise ValueError("Error de comunicacion")
      
        return token
    
    def refresh_token(self,token:str)->dict:
        if not self.__handler:
            raise ValueError("Controlador keycloak no instanciado")
        try:
            token = self.__handler.refresh_token(token)
        except KeycloakAuthenticationError as e:
            raise ValueError("Error de autenticacion")
        except KeycloakError as e:
            raise ValueError("Error de comunicacion")
        
        return token

    
    
