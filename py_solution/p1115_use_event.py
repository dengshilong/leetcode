import threading


class FooBar(object):
    def __init__(self, n):
        self.n = n
        self.ea = threading.Event()
        self.eb = threading.Event()
        self.ea.set()

    def foo(self, printFoo):
        """
        :type printFoo: method
        :rtype: void
        """
        for i in range(self.n):
            # printFoo() outputs "foo". Do not change or remove this line.
            self.ea.wait()
            # print('bbbb')
            printFoo()
            self.eb.set()
            # print('cccc')

    def bar(self, printBar):
        """
        :type printBar: method
        :rtype: void
        """
        for i in range(self.n):
            # printBar() outputs "bar". Do not change or remove this line.
            # print('lllll')
            self.eb.wait()
            # print('aaaa')
            printBar()
            self.ea.set()


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