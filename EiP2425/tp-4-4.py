import turtle
import math

#    a
#    _
# f |_| b
# e |_| c
#
#    g
#    +
#    d


def arc(t, r, angle):
    arc_length = 2 * math.pi * r * abs(angle) / 360
    n = int(arc_length / 4) + 1
    step_length = arc_length / n
    step_angle = float(angle) / n

    t.rt(step_angle / 2)
    for _ in range(n):
        t.fd(step_length)
        t.rt(step_angle)
    t.lt(step_angle / 2)


def r8bit(t, w, h, a, b, c, d, e, f, g):
    # draw segment "g"
    t.pu()
    if g:
        t.pd()
    t.fd(w)
    t.rt(90)
    t.pu()

    if c:
        t.pd()
    t.fd(h)
    t.pu()
    t.rt(90)

    if d:
        t.pd()
    t.fd(h)
    t.pu()
    t.rt(90)

    if e:
        t.pd()
    t.fd(h)
    t.pu()

    if f:
        t.pd()
    t.fd(h)
    t.pu()
    t.rt(90)

    if a:
        t.pd()
    t.fd(h)
    t.pu()
    t.rt(90)

    if b:
        t.pd()
    t.fd(h)

    t.lt(90)


def space(t, w):
    t.pu()
    t.fd(w)
    t.pd()


def draw_a(t):
    r8bit(
        t,
        50,
        50,
        a=True,
        b=True,
        c=True,
        d=True,
        e=True,
        f=False,
        g=True,
    )


def draw_b(t):
    r8bit(
        t,
        50,
        50,
        a=False,
        b=False,
        c=True,
        d=True,
        e=True,
        f=True,
        g=True,
    )


def alt_draw_a(t, l, w):
    c = math.cos(math.radians(w)) * l * 2.0
    h = math.sin(math.radians(w)) * l

    t.pu()
    t.fd(c)
    t.pd()

    t.lt(180 - w)
    t.fd(l)

    t.lt(w * 2)
    t.fd(l)

    t.pu()
    t.rt(w + 90)
    t.fd(h * 0.5)
    t.pd()

    t.rt(90)
    t.fd(c)

    t.pu()
    t.rt(90)
    t.fd(h * 0.5)
    t.lt(90)
    t.pd()


def alt_draw_b(t, l):
    t.lt(90)
    t.fd(l)

    t.rt(90)
    arc(t, l / 4, 180)
    t.rt(180)
    arc(t, l / 4, 180)
    t.rt(180)


t = turtle.Turtle()
t.pu()
t.goto(-300, 0)
t.pd()
draw_a(t)
space(t, 25)
draw_b(t)
space(t, 100)
alt_draw_a(t, 100, 70)
t.pu()
space(t, 100)
t.pd()
alt_draw_b(t, 100)
turtle.mainloop()
