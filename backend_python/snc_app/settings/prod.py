from .base import *

# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = False

ALLOWED_HOSTS = ["*"]

GOOGLE_DRIVE_STORAGE_JSON_KEY_FILE = str(BASE_DIR)+'/conf/hybrid-unity-275617-1a6ce24ce476.json'
GOOGLE_DRIVE_STORAGE_MEDIA_ROOT = 'sgc/uploads'

# Database
# https://docs.djangoproject.com/en/3.2/ref/settings/#databases

STATIC_ROOT = '/files'

ARCGIS_SERVER_URL = 'https://srvagspru.sgc.gov.co/arcgis/rest/services'

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': 'dbase',
        'USER': 'user',
        'PASSWORD': 'pass',
        'HOST': 'db',
        'PORT': 5432,
    }
}

# Logging
# https://docs.djangoproject.com/en/4.0/topics/logging/
LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'formatters': {
        'simple': {
            'format': '[{levelname}] {asctime} {name} {funcName} line:{lineno} :: {message} ',
            'style': '{',
        },
        'verbose': {
            'format': '[{levelname}] {asctime} {name} {module} {process:d} {thread:d} line:{lineno} :: {message}',
            'style': '{',
        },
    },
    'handlers': {
        'console': {
            'class': 'logging.StreamHandler',
            'formatter': 'simple',
        },
        'file': {
            'level': 'DEBUG',
            'class': 'logging.handlers.RotatingFileHandler',
            'filename': 'debug.log',
            'maxBytes': 1024*1024*10,  # 10 MB
            'backupCount': 10,
            'formatter': 'verbose'
        }
    },
    'root': {
        'handlers': ['console', 'file'],
        'level': 'INFO',
    },
    'loggers': {
            'django': {
                'handlers': ['console', 'file'],
                'level': os.getenv('DJANGO_LOG_LEVEL', 'INFO'),
                'propagate': False,
            },
        },
}