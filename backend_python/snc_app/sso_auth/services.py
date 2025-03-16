from django.contrib.auth import authenticate
from django.contrib.auth import get_user_model
from snc_app.sso_auth.serializers import LoginSerializer
from snc_app.sso_auth.utils import SSOAuth
from keycloak import KeycloakOpenID
import os

def authenticate_user(username, password):
    """
    Authenticate a user with username and password.
    Returns a user object if successful, None otherwise.
    """
    user = authenticate(username=username, password=password)
    return user


class SSOServicesClass:

    serializer_class = LoginSerializer 
    default_keycloak_class=KeycloakOpenID
    @classmethod
    def validate_data(cls,data)->object:
        serializer_objt = cls.serializer_class(data=data)
        serializer_objt.is_valid(raise_exception=True)
        return serializer_objt 

    @classmethod
    def get_sso_object_instance(cls):
        return SSOAuth(
            url="http://keycloak:8080/",
            client_id=os.environ.get("KEYCLOAK_CLIENT",""),
            client_secret=os.environ.get("KEYCLOAK_SECRET",""),
            realm_name=os.environ.get("REALM","")
        )

    @classmethod
    def connect_sso(cls,data):
        validate_data = cls.validate_data(data)
        print(os.environ.get("KEYCLOAK_URI",""))
        request_handler= cls.get_sso_object_instance() 
        request_handler.instance_openid_manager(
            KeycloakOpenID
        )
        token_data = request_handler.auth_by_password(
            username=validate_data.validated_data.get("user"),
            password=validate_data.validated_data.get("password")
        )
        return token_data
        

    @classmethod
    def logout_sso(cls,token):
        token_out = cls.get_sso_object_instance()
        token_out.instance_openid_manager(
            KeycloakOpenID
        )
        token_out.logout(token)

    @classmethod
    def refresh_sso(cls,token):
        token_out = cls.get_sso_object_instance()
        token_out.instance_openid_manager(
            KeycloakOpenID
        )
        return token_out.refresh_token(token)    


