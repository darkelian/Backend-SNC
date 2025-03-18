# Gunicorn configuration file
# https://docs.gunicorn.org/en/stable/configure.html#configuration-file
# https://docs.gunicorn.org/en/stable/settings.html
import multiprocessing

max_requests = 1000
max_requests_jitter = 50

# Django WSGI application path in pattern MODULE_NAME:VARIABLE_NAME
wsgi_app = " snc_app.wsgi:application"
reload = True

workers = 3

bind = '0.0.0.0:8000'
raw_env = ["DJANGO_SETTINGS_MODULE=snc_app.settings.test"]

