
from snc_app.shared_app.models import RequestAudit


class AuditMiddleware:
    def __init__(self, get_response):
        self.get_response = get_response
        # One-time configuration and initialization.

    def __call__(self, request):
        # Code to be executed for each request before
        # the view (and later middleware) are called.

        if request.method != 'GET':
            audit = RequestAudit()
            audit.method = request.method
            audit.path = request.META['PATH_INFO']
            if 'HTTP_USUARIO' in request.META:
                audit.usuario = request.META['HTTP_USUARIO']
            audit.user_agent = request.META['HTTP_USER_AGENT']

            if 'CONTENT_TYPE' in request.META and 'multipart/form-data' in request.META['CONTENT_TYPE']:
                audit.request = request.POST
            else:
                audit.request = request.body


        response = self.get_response(request)

        if request.method != 'GET' and response.status_code != 301:

            try:
                if response.data and len(str(response.data)) > 4999:
                    audit.response = str(response.data)[0: 4999]
                else:
                    audit.response = str(response.data)

                audit.status = response.status_code

                if audit.request and len(str(audit.request)) > 4999:
                    audit.request = audit.request[0: 4999]
                else:
                    audit.request = audit.request
                audit.save()
            except Exception as err:
                print(err)

        # Code to be executed for each request/response after
        # the view is called.

        return response