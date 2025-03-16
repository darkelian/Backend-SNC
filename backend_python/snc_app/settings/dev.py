from .base import *
import os
# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = True

ALLOWED_HOSTS = ["*"]


STATIC_ROOT = '/files/static'

# Database
# https://docs.djangoproject.com/en/3.2/ref/settings/#databases

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': os.environ.get('MAIN_DB'),
        'USER': os.environ.get('MAIN_APP_USER'),
        'PASSWORD': os.environ.get('MAIN_APP_PASSWORD'),
        'HOST': 'db',
        'PORT': 5432,
    }
}

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
            'class':'logging.handlers.RotatingFileHandler',
            # 'class':'logging.handlers.TimedRotatingFileHandler',
            'filename': 'debug.log',
            'maxBytes': 1024 * 5,  # 5 MB
            'backupCount': 5,
            'formatter': 'verbose'
        },
    },
    'root': {
        'handlers': ['console'],
        'level': 'DEBUG',
    },
    'loggers': {
            '': {
                'level': 'INFO',
                'handlers': ['console'],
            },
            'django': {
                'handlers': ['console'],
                'level': os.getenv('DJANGO_LOG_LEVEL', 'INFO'),
                'propagate': False
            },
        },
}
