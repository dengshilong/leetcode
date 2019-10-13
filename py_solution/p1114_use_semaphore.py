import threading


class Foo(object):
    def __init__(self):
        self.sa = threading.Semaphore(0)
        self.sb = threading.Semaphore(0)

    def first(self, printFirst):
        """
        :type printFirst: method
        :rtype: void
        """
        # printFirst() outputs "first". Do not change or remove this line.
        printFirst()
        self.sa.release()

    def second(self, printSecond):
        """
        :type printSecond: method
        :rtype: void
        """
        self.sa.acquire()
        # printSecond() outputs "second". Do not change or remove this line.
        printSecond()
        self.sb.release()

    def third(self, printThird):
        """
        :type printThird: method
        :rtype: void
        """
        self.sb.acquire()
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
