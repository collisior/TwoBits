import re


def is_valid_name(name):
    name_max_length = 30
    if name == "":
        return False
    if name.isalpha() and len(name) < name_max_length:
        return True


def is_valid_email(email):
    regex = '^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$'
    if re.search(regex, email):
        return True
    else:
        return False


def is_valid_phone(phone):
    if len(phone.strip()) != 12:
        return False
    if len(phone.strip()) == 12 and phone.isnumeric():
        return True

