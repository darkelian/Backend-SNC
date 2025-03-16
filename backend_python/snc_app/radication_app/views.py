from .serializers import *
from .models import *
import django_filters.rest_framework
from rest_framework import viewsets
from rest_framework import permissions
from rest_framework import filters


# Create your views here.

class TransactViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows radicates to be viewed or edited.
    """
    queryset = Transact.objects.all()
    serializer_class = TransactSerializer
    #permission_classes = [permissions.IsAuthenticated]
    filter_backends = [django_filters.rest_framework.DjangoFilterBackend, filters.SearchFilter]
    filter_fields = ['resolution_number']
    search_fields = ['resolution_number']