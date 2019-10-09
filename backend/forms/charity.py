class Charity:

    def __init__(self, charity_name, category, email):
        self.charity_name = charity_name
        self.category = category
        self.email = email

    def get_charity_name(self):
        return self.charity_name

    def set_charity_name(self, new_charity_name):
        self.charity_name = new_charity_name

    def get_category(self):
        return self.category

    def set_category(self, new_category):
        self.category = new_category

    def get_email(self):
        return self.email

    def set_email(self, new_email):
        self.email = new_email

