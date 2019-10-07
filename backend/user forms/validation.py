import re

def isValidName(name):
    name_max_length = 30
    if name == "":
        return False
    return True

def isValidEmail(email):
    regex = '^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$'
    if(re.search(regex, email)):
        return True
    else :
        return False

def isValidPhone(phone):
    if len(phone) != 12:

