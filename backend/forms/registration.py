from . import validate


def testing():
    res = validate.is_valid_phone("123456")
    print(res)


testing()


class User(object):

    def __init__(self, name):
        self.name = name

    firstName = ""
    lastName = ""
    phone = ""
    username = ""
    email = ""
    password = ""
    confirm_password = ""
    # terms & conditions accept checkbox boolean
    accept = True

# class