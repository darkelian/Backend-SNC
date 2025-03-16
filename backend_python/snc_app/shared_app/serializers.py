from .models import *
from rest_framework import serializers


class GroupSerializer(serializers.ModelSerializer):
    class Meta:
        model = Group
        fields = ['id', 'name']


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        groups = GroupSerializer(many=True, read_only=True)
        fields = ['id', 'username', 'first_name', 'last_name', 'is_active', 'email', 'groups']

