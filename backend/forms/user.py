class User:

    def __init__(self, username, first_name, last_name, phone, email):
        self.username = username
        self.first_name = first_name
        self.last_name = last_name
        self.phone = phone
        self.email = email

    def get_username(self):
        return self.username

    def set_username(self, new_username):
        self.username = new_username

    def get_first_name(self):
        return self.first_name

    def set_first_name(self, new_first):
        self.first_name = new_first

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last):
        self.last_name = last

    def get_phone(self):
        return self.phone

    def set_phone(self, new_phone):
        self.phone = new_phone

    def get_email(self):
        return self.email

    def set_email(self, new_email):
        self.email = new_email

