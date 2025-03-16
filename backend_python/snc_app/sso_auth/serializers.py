from rest_framework import serializers



class LoginSerializer(serializers.Serializer):
    """clase """
    user = serializers.CharField(
        max_length=50
    )

    password = serializers.CharField(
        max_length=100
    )

