from __future__ import absolute_import
import validate


def testing():
    res = validate.is_valid_phone("123456")
    print(res)
