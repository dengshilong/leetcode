import threading
import queue

class Foo(object):
    def __init__(self):
        self.qa = queue.Queue()
        self.qb = queue.Queue()

    def first(self, printFirst):
        """
        :type printFirst: method
        :rtype: void
        """
        # printFirst() outputs "first". Do not change or remove this line.
        printFirst()
        self.qa.put(0)

    def second(self, printSecond):
        """
        :type printSecond: method
        :rtype: void
        """
        self.qa.get()
        # printSecond() outputs "second". Do not change or remove this line.
        printSecond()
        self.qb.put(0)

    def third(self, printThird):
        """
        :type printThird: method
        :rtype: void
        """
        self.qb.get()
        # printThird() outputs "third". Do not change or remove this line.
        printThird()


def printFirst():
    print('one')


def printSecond():
    print('two')


def printThird():
    print('three')


if __name__ == "__main__":
    foo = Foo()
    a = threading.Thread(target=foo.first, args=(printFirst,))
    b = threading.Thread(target=foo.second, args=(printSecond,))
    c = threading.Thread(target=foo.third, args=(printThird,))
    c.start()
    b.start()
    a.start()
    a.join()
    b.join()
    c.join()
