from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='example-home'),
    path('sales/', views.sales, name = 'example-sales'),
]
