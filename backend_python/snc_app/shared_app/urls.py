from django.urls import include, path
from rest_framework import routers
from .views import *

router = routers.DefaultRouter()
# router.register(r'group', GroupExtViewSet)


urlpatterns = [
    # path('users/find_user/<path:email>', UserExtView.as_view(), name='find_user'),
    path('', include(router.urls))
]
