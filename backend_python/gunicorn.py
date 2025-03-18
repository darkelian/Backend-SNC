# Gunicorn configuration file
# https://docs.gunicorn.org/en/stable/configure.html#configuration-file
# https://docs.gunicorn.org/en/stable/settings.html
import multiprocessing

max_requests = 1000
max_requests_jitter = 50
keepalive = 120
timeout = 300
worker_class = "gthread"
threads = 3


# Django WSGI application path in pattern MODULE_NAME:VARIABLE_NAME
wsgi_app = " snc_app.wsgi:application"

# The number of worker processes for handling requests
workers = multiprocessing.cpu_count() * 2 + 1

# The socket to bind
bind = '0.0.0.0:8000'
# Options django file
raw_env = ["DJANGO_SETTINGS_MODULE=snc_app.settings.prod"]

