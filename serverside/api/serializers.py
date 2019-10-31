from django.contrib.auth import get_user_model
from rest_framework import serializers


User = get_user_model()


class UserSerializer(serializers.ModelSerializer):

    class Meta:
        model = User
        # Tuple of serialized model fields (see link [2])
        fields = ['username', 'password','email',]
        extra_kwargs = {"password": {"write_only":True}}
    