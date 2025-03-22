from rest_framework import serializers
from snc_app.sso_auth.utils import GetGeneralTokenInfo


class LoginSerializer(serializers.Serializer):
    """clase """
    user = serializers.CharField(
        max_length=50
    )

    password = serializers.CharField(
        max_length=100
    )

    def _representate_sso_data(self,res={},user={}):
        return {
            "user":user,
            "token":res
        }

    def _process_data_token(self,token):
        decoder = GetGeneralTokenInfo(token)
        user_token_decoded=decoder.decode_and_get_user()
        return user_token_decoded
    
    def get_response_sso(self,response,key_ref="access_token"):
        
        token = response.get(key_ref)
        if not token:
            serializers.ValidationError({"message":"No fue posible autenticar"})
        user = self._process_data_token(token)
        data = self._representate_sso_data(response,user)
        return data


   
