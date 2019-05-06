from django.db import models
from django.contrib.auth.models import User

class AuthGroup(models.Model):
    name = models.CharField(unique=True, max_length=80)

    class Meta:
        db_table = 'auth_group'


class AuthGroupPermissions(models.Model):
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)
    permission = models.ForeignKey('AuthPermission', models.DO_NOTHING)

    class Meta:
        db_table = 'example.auth_group_permissions'
        unique_together = (('group', 'permission'),)


class AuthPermission(models.Model):
    name = models.CharField(max_length=255)
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING)
    codename = models.CharField(max_length=100)

    class Meta:
        db_table = 'auth_permission'
        unique_together = (('content_type', 'codename'),)


class AuthUser(models.Model):
    password = models.CharField(max_length=128)
    last_login = models.DateTimeField(blank=True, null=True)
    is_superuser = models.IntegerField()
    username = models.CharField(unique=True, max_length=150)
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=150)
    email = models.CharField(max_length=254)
    is_staff = models.IntegerField()
    is_active = models.IntegerField()
    date_joined = models.DateTimeField()

    class Meta:
        db_table = 'auth_user'


class AuthUserGroups(models.Model):
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)

    class Meta:
        db_table = 'example.auth_user_groups'
        unique_together = (('user', 'group'),)


class AuthUserUserPermissions(models.Model):
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    permission = models.ForeignKey(AuthPermission, models.DO_NOTHING)

    class Meta:
        db_table = 'example.auth_user_user_permissions'
        unique_together = (('user', 'permission'),)


class BackInventory(models.Model):
    iid = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=100, blank=True, null=True)
    quantity = models.IntegerField(blank=True, null=True)
    unit_price = models.DecimalField(max_digits=10, decimal_places=2, blank=True, null=True)

    class Meta:
        db_table = 'back_inventory'
        app_label = 'example'
        verbose_name_plural = 'Back Inventory'

    def __str__(self):
        return self.name


class Customer(models.Model):
    cid = models.IntegerField(primary_key=True)
    first_name = models.CharField(max_length=30, blank=True, null=True)
    last_name = models.CharField(max_length=30, blank=True, null=True)
    street = models.CharField(max_length=50, blank=True, null=True)
    city = models.CharField(max_length=20, blank=True, null=True)
    state = models.CharField(max_length=2, blank=True, null=True)
    zip = models.CharField(max_length=10, blank=True, null=True)
    phone = models.CharField(max_length=20, blank=True, null=True)
    email = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        db_table = 'customer'
        app_label = 'example'

    def __str__(self):
        return self.first_name + str(" ") + self.last_name


class DjangoAdminLog(models.Model):
    action_time = models.DateTimeField()
    object_id = models.TextField(blank=True, null=True)
    object_repr = models.CharField(max_length=200)
    action_flag = models.PositiveSmallIntegerField()
    change_message = models.TextField()
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)

    class Meta:
        db_table = 'django_admin_log'


class DjangoContentType(models.Model):
    app_label = models.CharField(max_length=100)
    model = models.CharField(max_length=100)

    class Meta:
        db_table = 'django_content_type'
        unique_together = (('app_label', 'model'),)


class DjangoMigrations(models.Model):
    app = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    applied = models.DateTimeField()

    class Meta:
        db_table = 'django_migrations'


class DjangoSession(models.Model):
    session_key = models.CharField(primary_key=True, max_length=40)
    session_data = models.TextField()
    expire_date = models.DateTimeField()

    class Meta:
        db_table = 'django_session'


class Employee(models.Model):
    eid = models.IntegerField(primary_key=True)
    first_name = models.CharField(max_length=15, blank=True, null=True)
    last_name = models.CharField(max_length=15, blank=True, null=True)
    store_num = models.SmallIntegerField(blank=True, null=True)

    class Meta:
        db_table = 'employee'
        app_label = 'example'
        verbose_name_plural = 'Employees'

    def __str__(self):
        return self.first_name + str(" ") + self.last_name


class FrontInventory(models.Model):
    iid = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=100, blank=True, null=True)
    quantity = models.IntegerField(blank=True, null=True)
    unit_price = models.DecimalField(max_digits=10, decimal_places=2, blank=True, null=True)

    class Meta:
        db_table = 'front_inventory'
        app_label = 'example'
        verbose_name_plural = 'Front Inventory'

    def __str__(self):
        return self.name


class Sales(models.Model):
    sid = models.IntegerField()
    cid = models.OneToOneField(Customer, models.DO_NOTHING, db_column='cid', primary_key=True)
    iid = models.ForeignKey(FrontInventory, models.DO_NOTHING, db_column='iid')
    date = models.DateField()
    quantity_sold = models.IntegerField(blank=True, null=True)
    sale_total = models.DecimalField(max_digits=15, decimal_places=2, blank=True, null=True)
    eid = models.ForeignKey(Employee, models.DO_NOTHING, db_column='eid', blank=True, null=True)

    class Meta:
        db_table = 'sales'
        unique_together = (('cid', 'iid', 'date'),)
        app_label = 'example'
        verbose_name_plural = 'Sales'

    def __str__(self):
        return self.cid.first_name + str(" ")+ self.cid.last_name + str(" (")+str(self.date)+ str(")")
