from rest_framework import status
from rest_framework.views import APIView
from rest_framework.response import Response
from django.contrib.auth import login
from snc_app.sso_auth.services import SSOServicesClass


class LoginView(APIView):
    """View for user login."""
    service_class= SSOServicesClass
    def post(self, request):
        """Handle POST request for user login."""
        try:

            token = SSOServicesClass.connect_sso(
                request.data
            ) 

           
            return Response(token)
        except (ValueError, AttributeError) as e:
            print(e)
            return Response({
                "code": "invalid_input",
                "detail": "Invalid input data. Please check your credentials."
            }, status=status.HTTP_400_BAD_REQUEST)
     
        except (ConnectionError, TimeoutError) as e:
          
            return Response({
                "code": "connection_error",
                "detail": "Unable to connect to the authentication service. Please try again later."
            }, status=status.HTTP_503_SERVICE_UNAVAILABLE)
        
class SSOLogoutView(APIView):
    service_class= SSOServicesClass
    def post(self, request):
        """Handle POST request for user login."""
        try:

            SSOServicesClass.logout_sso(
                request.data.get("token","")
            ) 

           
            return Response({
                "detail":"Sesion sso cerrada"
            })
        except (ValueError, AttributeError) as e:
            print(e)
            return Response({
                "code": "invalid_input",
                "detail": "Invalid input data. Please check your credentials."
            }, status=status.HTTP_400_BAD_REQUEST)
     
        except (ConnectionError, TimeoutError) as e:
          
            return Response({
                "code": "connection_error",
                "detail": "Unable to connect to the authentication service. Please try again later."
            }, status=status.HTTP_503_SERVICE_UNAVAILABLE)

class SSORefreshView(APIView):
    service_class= SSOServicesClass
    def post(self, request):
        """Handle POST request for user login."""
        try:

            token = SSOServicesClass.refresh_sso(
                request.data.get("refresh_token","")
            ) 

           
            return Response(token)
        except (ValueError, AttributeError) as e:
            print(e)
            return Response({
                "code": "invalid_input",
                "detail": "Invalid input data. Please check your credentials."
            }, status=status.HTTP_400_BAD_REQUEST)
     
        except (ConnectionError, TimeoutError) as e:
          
            return Response({
                "code": "connection_error",
                "detail": "Unable to connect to the authentication service. Please try again later."
            }, status=status.HTTP_503_SERVICE_UNAVAILABLE)
