from rest_framework import viewsets
from rest_framework import permissions
from django.contrib.auth.models import User, Group
import django_filters.rest_framework
from rest_framework import generics, status
from rest_framework import filters
from rest_framework.views import APIView
from rest_framework.response import Response
import logging
from .models import *
from .serializers import *


logger = logging.getLogger(__name__)
# Create your views here.


class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all().order_by('-date_joined')
    serializer_class = UserSerializer
    permission_classes = [permissions.IsAuthenticated]
    filter_backends = [django_filters.rest_framework.DjangoFilterBackend, filters.SearchFilter]
    filter_fields = ['username', 'email']


class GroupViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Group.objects.all()
    serializer_class = GroupSerializer
    permission_classes = [permissions.IsAuthenticated]
