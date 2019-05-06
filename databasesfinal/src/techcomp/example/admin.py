from django.contrib import admin
from .models import(FrontInventory, BackInventory, Customer, Employee, Sales)

# Register your models here.
admin.site.register(FrontInventory)
admin.site.register(BackInventory)
admin.site.register(Customer)
admin.site.register(Employee)
admin.site.register(Sales)

'''
def quantity_0(modeladmin, request, queryset):
	queryset.update(quantity=0)
	quantity_0.short_description = "Select items to change quantity_0"

class ArticleAdmin(admin.modeladmin):
	list_display['name', 'quantity']
	ordering = ['title']
	actions = quantity_0

admin.site.register(FrontInventory, FrontInventoryAdmin)
'''