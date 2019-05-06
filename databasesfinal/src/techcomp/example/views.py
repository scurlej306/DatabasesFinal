from django.shortcuts import render
from .models import FrontInventory, BackInventory, Customer, Employee, Sales

data = FrontInventory.objects.all()

items = {
	"iid": data
}

# Create your views here.
def home(request):
	context = {
	'posts': FrontInventory.objects.all()
	}
	return render(request, 'example/home.html', context)
	#views must always return an http response or an exception

def sales(request):
	#context = {
	#'sales': Sales.object.all()
	#}
	return render(request, 'example/sales.html')