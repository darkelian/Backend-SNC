from django.db import models
from django.contrib.auth.models import User, Group

# Create your models here.

class RequestAudit(models.Model):

    created_at = models.DateTimeField(auto_now_add=True, null=True)
    usuario = models.CharField('Usuario', null=True, max_length=50)
    method = models.CharField('Metodo', null=True, max_length=50)
    path = models.CharField('Ruta', null=True, max_length=100)
    user_agent = models.CharField('user_agent', max_length=200)
    request = models.CharField('Request',max_length=5000)
    response = models.CharField('Response',max_length=5000, null=True)
    status = models.CharField('Status',max_length=20, null=True)

    def __str__(self):
        return str(self.id) + '-' + str(self.method)

    class Meta:
        db_table = "request_audit"
