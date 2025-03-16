from django.contrib.gis.db import models
from django.contrib.auth.models import User, Group

from snc_app.radication_app.models.Radicates import Radicate


class CommonType(models.Model):
    id = models.BigAutoField(primary_key=True)
    dispname = models.CharField(max_length=70, unique=True)
    text_code = models.CharField(max_length=50, unique=True)
    
    def __str__(self):
        return self.dispname

    class Meta:
        abstract = True
        ordering = ['id']

#----------------------
# Types
#----------------------

class TransactStatusType(CommonType):
    """
    Transact state domain
    """
    
    class Meta:
        db_table = "tr_transact_status_type"

class TransactType(CommonType):
    """
    Transact domain
    """
    code = models.CharField(max_length=4, null=True, blank=True)
    value = models.PositiveIntegerField()

    class Meta:
        db_table = "tr_transact_type"

#----------------------
# Helpers
#----------------------

class TransactStatusHistory(models.Model):
    date = models.DateTimeField(auto_now_add=True)
    status = models.ForeignKey(TransactStatusType,models.DO_NOTHING, null=True, blank=True)
    #user_accountable_change_status = models.ForeignKey(User, models.DO_NOTHING, null=True, blank=True)
    transact = models.ForeignKey("Transact", models.CASCADE)
    
    class Meta:
        db_table = "tr_transact_status_history"

#----------------------
# Transact
#----------------------

class Transact(models.Model):
    """
    Transact model
    """
    id = models.BigAutoField(primary_key=True)
    radicate = models.ForeignKey(Radicate, models.DO_NOTHING)
    tr_order = models.IntegerField(default=0)
    type = models.ForeignKey(TransactType, models.DO_NOTHING)
    # Land condition selected by requesting_user
    land_condition = models.CharField(max_length=10, blank=True, null=True, default=None)
    # Default status pending (pk = 4)
    status = models.ForeignKey(TransactStatusType, models.DO_NOTHING, default=4)
    # user that creates transact
    user_creates = models.ForeignKey(User, models.DO_NOTHING, null=True, blank=True)
    resolution_number = models.CharField(max_length=20, blank=True,null=True,default=None)
    resolution_date = models.DateTimeField(null=True,blank=True)
    is_principal = models.BooleanField(default=False)
    date = models.DateTimeField(auto_now_add=True)

    class Meta:
        db_table = "tr_transact"
        ordering = ['-id']