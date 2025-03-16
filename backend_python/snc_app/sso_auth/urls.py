from django.urls import include, path
from .views import *

urlpatterns = [
    path('login/', LoginView.as_view(), name='login'),
    path('logout/', SSOLogoutView.as_view(), name='logot'),
    path('refresh/',SSORefreshView.as_view(), name='refresh'),
   
]
