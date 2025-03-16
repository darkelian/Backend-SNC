from dataclasses import dataclass
from typing import Type, TypeVar

T = TypeVar("T")  # Tipo genérico


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
        token = self.__handler.token(username, password)
        return token

    def logout(self,token:str)->dict:
        if not self.__handler:
            raise ValueError("Controlador keycloak no instanciado")
        token = self.__handler.logout(token)
        return token
    
    def refresh_token(self,token:str)->dict:
        if not self.__handler:
            raise ValueError("Controlador keycloak no instanciado")
        token = self.__handler.refresh_token(token)
        return token

    
    
