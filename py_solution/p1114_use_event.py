import threading


class Foo(object):
    def __init__(self):
        self.ea = threading.Event()
        self.eb = threading.Event()

    def first(self, printFirst):
        """
        :type printFirst: method
        :rtype: void
        """
        # printFirst() outputs "first". Do not change or remove this line.
        printFirst()
        self.ea.set()

    def second(self, printSecond):
        """
        :type printSecond: method
        :rtype: void
        """
        self.ea.wait()
        # printSecond() outputs "second". Do not change or remove this line.
        printSecond()
        self.eb.set()

    def third(self, printThird):
        """
        :type printThird: method
        :rtype: void
        """
        self.eb.wait()
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
