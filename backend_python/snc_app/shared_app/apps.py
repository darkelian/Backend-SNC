from django.apps import AppConfig


class SharedAppConfig(AppConfig):
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'snc_app.shared_app'
