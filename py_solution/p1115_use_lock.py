import threading


class FooBar(object):
    def __init__(self, n):
        self.n = n
        self.la = threading.Lock()
        self.lb = threading.Lock()
        self.lb.acquire()

    def foo(self, printFoo):
        """
        :type printFoo: method
        :rtype: void
        """
        for i in range(self.n):
            # printFoo() outputs "foo". Do not change or remove this line.
            self.la.acquire()
            # print('bbbb')
            printFoo()
            self.lb.release()
            # print('cccc')

    def bar(self, printBar):
        """
        :type printBar: method
        :rtype: void
        """
        for i in range(self.n):
            # printBar() outputs "bar". Do not change or remove this line.
            # print('lllll')
            self.lb.acquire()
            # print('aaaa')
            printBar()
            self.la.release()


def printFoo():
    print('foo')


def printBar():
    print('bar')


if __name__ == "__main__":
    n = 10
    foo_bar = FooBar(n)
    foo = threading.Thread(target=foo_bar.foo, args=(printFoo,))
    bar = threading.Thread(target=foo_bar.bar, args=(printBar,))
    foo.start()
    bar.start()
    foo.join()
    bar.join()