from .models import *
from rest_framework import serializers

from .models.Transacts import Transact
from .models.Radicates import Radicate


class RadicateSerializer(serializers.ModelSerializer):
    class Meta:
        model = Radicate
        fields = ['status', 'radicated_number', 'user_create', 'type_user_create', 'user_beneficiary_offline']


class TransactSerializer(serializers.ModelSerializer):
    """
    Serializing the Transact instances into representations.
    """
    radicate = RadicateSerializer()

    class Meta:
        model = Transact
        fields = ('id', 'resolution_number', 'land_condition', 'status', 'type', 'date', 'radicate')

    def create(self, validated_data):
            radicate = Radicate.objects.create(**validated_data.pop('radicate'))
            instance = Transact.objects.create(radicate_id=radicate.radicated_number, **validated_data)
            return instance







