from django.db import models
from datetime import date
from django import utils

# Create your models here.

class Audit(models.Model):
    created_at = models.DateTimeField(auto_now_add=True, null=True)
    updated_at = models.DateTimeField(auto_now=True)
    usuario_log = models.CharField('Usuario', null=True, max_length=50)

    class Meta:
        abstract = True

