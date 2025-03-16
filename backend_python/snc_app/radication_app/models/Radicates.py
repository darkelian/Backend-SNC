from django.contrib.gis.db import models
from django.contrib.auth.models import User, Group


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

class RadicateStatusType(CommonType):
    """
    Radicate state domain
    """
    
    class Meta:
        db_table = "radicate_status_type"

class RadicateCreateUserType(CommonType):
    """
    Type of user that creates the radicate
    """
    class Meta:
        db_table = "radicate_create_user_type"

class WorldCountry(models.Model):
    id = models.SmallAutoField(primary_key=True)
    country_name = models.CharField(max_length=60)
    country_abb = models.CharField(max_length=2)
    country_icon = models.CharField(max_length=20)
    country_ident = models.CharField(max_length=4)

    class Meta:
        db_table = 'tr_world_countries'
    
class ColombianState(models.Model):
    id = models.CharField(primary_key=True, max_length=3)
    state_name = models.CharField(max_length=50)
    country = models.ForeignKey(WorldCountry, on_delete=models.CASCADE)

    class Meta:
        db_table = 'tr_colombia_states'
    
class ColombianTown(models.Model):
    id = models.CharField(primary_key=True, max_length=6)
    town_name = models.CharField(max_length=30)
    state = models.ForeignKey(ColombianState, on_delete=models.CASCADE)
    is_in_jurisdiction = models.BooleanField(default=False)

    class Meta:
        db_table = 'tr_colombia_towns'

#----------------------
# Helpers
#----------------------

class UserBeneficiaryOffline(models.Model):
    """
    User who benefits from the requested transact
    """
    id = models.BigAutoField(primary_key=True)
    first_name = models.CharField(max_length=30,null=True)
    second_name = models.CharField(max_length=30,null=True, default=None)
    first_last_name  = models.CharField(max_length=30, null=True, blank=True)
    second_last_name  = models.CharField(max_length=30, null=True, blank=True, default=None)
    # Business name of user
    business_name  = models.CharField(max_length=250, null=True, blank=True)
    identification_number = models.CharField(max_length=30, null=True)
    identification_date = models.DateField(null=True, default=None)
    #identification_type = models.ForeignKey(UserIdentificationType, models.DO_NOTHING,null=True,blank=True)
    phone = models.CharField(max_length=30, null=True)
    phone_indicative = models.CharField(max_length=10, null=True, default=None)
    address = models.CharField(max_length=255, null=True)
    country = models.CharField(max_length=30, null=True, default=None)
    residence_town = models.CharField(max_length=6, null=True)
    state = models.CharField(max_length=3, null=True, default=None)
    email = models.EmailField(blank=True, help_text='Correo electrónico', null=True, unique=True)
    type_user = models.ForeignKey(RadicateCreateUserType, models.DO_NOTHING, null=True, blank=True)
    is_accepted_email_communication = models.BooleanField(null=True, default=None)

    class Meta:
        #   unique_together = ('identification_type', 'identification_number')
        db_table = "tr_user_beneficiary"

class RadicateStatusHistory(models.Model):
    date = models.DateTimeField(auto_now_add=True)
    status = models.ForeignKey(RadicateStatusType,models.DO_NOTHING, null=True, blank=True)
    user_accountable_change_status = models.ForeignKey(User, models.DO_NOTHING, null=True, blank=True)
    radicate = models.ForeignKey("Radicate", models.CASCADE)
    
    class Meta:
        db_table = "tr_radicate_status_history"

# ?
class RadicateSequence(models.Model):
    id = models.BigAutoField(primary_key=True)
    year =  models.CharField(max_length=4,  default=None, blank=True, null=True)
    site = models.CharField(max_length=3, default=None, blank=True, null=True)
    sequence =  models.DecimalField(max_digits=7, decimal_places=0)
    
    class Meta:
        db_table = "tr_radicate_sequences"

#----------------------
# Radicate
#----------------------

class Radicate(models.Model):
    """
    Radicate model
    """
    radicated_number = models.CharField(primary_key=True, max_length=20)
    radicated_date = models.DateTimeField(auto_now_add=True)
    status = models.ForeignKey(RadicateStatusType, models.DO_NOTHING, default=1)
    town = models.ForeignKey(ColombianTown, models.DO_NOTHING, null=True)
    state = models.CharField(max_length=6)
    # user that creates transact
    user_create = models.ForeignKey(User, models.DO_NOTHING, related_name="user_create")
    type_user_create = models.ForeignKey(RadicateCreateUserType, models.DO_NOTHING)
    # User who benefits from the transact wheter it be offline or online
    user_beneficiary_offline = models.ForeignKey(UserBeneficiaryOffline, models.DO_NOTHING, null=True, blank=True)
    #   initial_transact_type = models.ForeignKey(TransactType, models.DO_NOTHING, null=True)
    requires_visit = models.BooleanField(default=False)
    #site = models.ForeignKey(Site, models.DO_NOTHING, null=True)
    date_expiration_medium = models.DateField(null=True)
    date_expiration_maximum = models.DateField(null=True)

    class Meta:
        db_table = "tr_radicate"
        ordering = ['-radicated_number']