"""restdq URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""

from django.urls import include, path
from rest_framework import routers
from snc_app.settings import base as settings
from django.conf.urls.static import static
from snc_app.shared_app.urls import urlpatterns as router_shared_urls
from snc_app.asigment_app.urls import urlpatterns as router_asigment_urls
from snc_app.radication_app.urls import urlpatterns as router_radication_urls
from snc_app.sso_auth.urls import urlpatterns as router_login_urls
from drf_spectacular.views import SpectacularAPIView, SpectacularSwaggerView


router = routers.DefaultRouter()

# Wire up our API using automatic URL routing.
# Additionally, we include login URLs for the browsable API.
urlpatterns = [
    path('api/', include(router.urls)),
    path('api/auth/', include(router_login_urls)),
    path('api/shared/', include(router_shared_urls)),
    path('api/radication/', include(router_radication_urls)),
    path('api/asigment/', include(router_asigment_urls)),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    #path("", include("docApp.urls")),
        path('api/schema/', SpectacularAPIView.as_view(), name='schema'),
    path('api/docs/', SpectacularSwaggerView.as_view(url_name='schema'), name='swagger-ui'),
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
