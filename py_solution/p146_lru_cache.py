from collections import OrderedDict

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            value = self.cache[key]
            self.cache.move_to_end(key, last=True)
            return value
        return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache:
            self.cache.move_to_end(key, last=True)
            self.cache[key] = value
        else:
            if len(self.cache.keys()) == self.capacity:
                self.cache.popitem(last=False)
            self.cache[key] = value



if __name__ == "__main__":
    # cache = LRUCache(2)
    # cache.put(1, 1)
    # cache.put(2, 2)
    # assert cache.get(1) == 1
    # cache.put(3, 3)
    # assert cache.get(2) == -1
    # cache.put(4, 4)
    # assert cache.get(1) == -1
    # assert cache.get(3) == 3
    # assert cache.get(4) == 4
    cache = LRUCache(2)
    cache.put(2, 1)
    cache.put(1, 1)
    cache.put(2, 3)
    cache.put(4, 1)
    assert cache.get(1) == -1
    assert cache.get(2) == 3

