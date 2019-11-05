from django.contrib import admin
from django.urls import path, include
from serverside.router import router
from . import views
urlpatterns = [
    path('', views.UserCreateAPIView.as_view(), name='user-list'),
]
