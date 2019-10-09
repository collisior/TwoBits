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


class UserCharityInfo(User):

    def __init__(self, charity_categories, charities):
        self.charity_categories = charity_categories
        self.charities = charities

    def add_charity_category(self, category):
        self.charity_categories.append(category)

    def remove_charity_category(self, category):
        self.charity_categories.remove(category)

    def add_charity(self, charity):
        self.charities.append(charity)

    def remove_charity(self, charity):
        self.charities.remove(charity)