The reach of a knot is indicated by the basic property knotreach. A knotreach of 0 means that a knot can only be connected to itself.

```
[ ][ ][ ]
[ ][k][ ]
[ ][ ][ ]
```

A knotreach of 1 means it can be connected to all tiles within 1 tile.

```
[ ][ ][ ][ ][ ]
[ ][c][c][c][ ]
[ ][c][k][c][ ]
[ ][c][c][c][ ]
[ ][ ][ ][ ][ ]
```

However, a knotreach of two would allow a knot to be connected to these tiles.

```
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][c][c][c][ ][ ]
[ ][c][c][c][c][c][ ]
[ ][c][c][k][c][c][ ]
[ ][c][c][c][c][c][ ]
[ ][ ][c][c][c][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
```

And this is the case for a knotreach of three.

```
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][c][c][c][ ][ ][ ]
[ ][ ][ ][c][c][c][ ][ ][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][k][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][ ][ ][c][c][c][ ][ ][ ]
[ ][ ][ ][c][c][c][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

And four.

```
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][c][c][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][k][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][c][c][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

The reason behind this is the way connections occupy tiles or tiles are checked for the presence of a connection on them. Tiles don't hold any data as to what connections go through them. Whether a tile is occupied by a connection is tested by checking for the presence of knots in any of the tiles within knotreach in positive and negative direction of both axis and checking the knots any found knot is connected to.

This shows the example with a knotreach of 6.

```
t : tile being tested
c : tile that must be checked for the presence of a knot

[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][c][c][c][c][c][c][t][c][c][c][c][c][c][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][c][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

A connection takes over tiles like this:

```
k : knot connected to the other knot
c : tiles occupied by a connection between knots

[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][c][c][c][c][c][c][k][ ]
[ ][k][c][c][c][c][c][c][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]

[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][c][c][c][c][c][k][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]

[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][k][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

As stated, these can't be connected.

```
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][k][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

It's costly to check for the presence of knots as this forces you to check for all nearby tiles rather than just the ones in a cross.

```
c : tiles from where the knot can be found if checking along the two axis
! : tiles that would theoretically be occupied by the connection but have no nearby knots following the axis

[ ][c][ ][ ][ ][ ][ ][c][ ]
[c][k][c][c][c][c][c][c][c]
[ ][c][!][!][!][!][!][c][ ]
[c][c][c][c][c][c][c][k][c]
[ ][c][ ][ ][ ][ ][ ][c][ ]
```

Not to mention such a diagonal connection would either take up a lot of tiles or make it more complex to check whether a connection occupies a tile.

```
* occupies all tiles with k < tile < k',
* checking whether a tile is occupied is a O(^2) operation
* graphics more complex to compose

[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][c][ ]
[ ][c][c][c][c][c][c][k][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

*occupies all tiles with similar proportion between connections, ceiled and floored
*checking whether a tile is occupied is a O(^2) operation
*graphics more complex to compose

```
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][c][ ][ ][ ][ ][ ][ ]
[ ][c][c][c][ ][ ][ ][ ][ ]
[ ][ ][c][c][c][ ][ ][ ][ ]
[ ][ ][ ][c][c][c][ ][ ][ ]
[ ][ ][ ][ ][c][c][c][ ][ ]
[ ][ ][ ][ ][ ][c][c][c][ ]
[ ][ ][ ][ ][ ][ ][c][k][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ]
```

In the end, these are the tiles where a second knot can be for a first knot to connect to it, still assuming a knotreach of 6:

a : allowed tiles

[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][a][a][a][a][a][a][a][a][a][a][a][a][a][ ]
[ ][a][a][a][a][a][a][k][a][a][a][a][a][a][ ]
[ ][a][a][a][a][a][a][a][a][a][a][a][a][a][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][a][a][a][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]

The presence of a connection in a tile is tested by:

(tile tested -> boolean):
	//check tiles between (-reach, 0) along the x axis
	FOR tile IN (tiles WITH tested.y - reach < tile.y < 0 + reach AND tested.x == tile.x):
		IF tile.knot :
			FOR knot IN tile.knot.knots :
				IF knot.y > 0 AND tile.x - 1 <= knot.x <= tile.x + 1 :
					RETURN TRUE
	//check tiles between (0, reach) along the x axis
	FOR tile IN (tiles WITH 0 < tile.y < tested.y + reach + reach AND tested.x == tile.x):
		IF tile.knot :
			FOR knot IN tile.knot.knots :
				IF knot.y < 0 AND tile.x - 1 <= knot.x <= tile.x + 1 :
					RETURN TRUE
	//check tiles between (-reach, 0) along the y axis
	FOR tile IN (tiles WITH tested.x - reach < tile.x < 0 + reach AND tested.y == tile.y):
		IF tile.knot :
			FOR knot IN tile.knot.knots :
				IF knot.x > 0 AND tile.y - 1 <= knot.y <= tile.y + 1 :
					RETURN TRUE
	//check tiles between (0, reach) along the y axis
	FOR tile IN (tiles WITH 0 < tile.x < tested.x + reach + reach AND tested.y == tile.y):
		IF tile.knot :
			FOR knot IN tile.knot.knots :
				IF knot.x < 0 AND tile.y - 1 <= knot.y <= tile.y + 1 :
					RETURN TRUE
	RETURN FALSE

It's possible to create lines

... : arbitrary repetition of tiles assuming infinite reach

[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]
[ ][k][c]...[c][k][c]...[c][k][c]...[c][k][c]
[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]

[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]
[ ][ ][ ]...[ ][ ][ ]...[ ][c][c]...[c][k][ ]
[ ][ ][ ]...[ ][c][c]...[c][k][c]...[c][c][ ]
[ ][c][c]...[c][k][c]...[c][c][ ]...[ ][ ][ ]
[ ][k][c]...[c][c][ ]...[ ][ ][ ]...[ ][ ][ ]
[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]...[ ][ ][ ]

and curves

[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][k]
[ ][ ][ ][ ][ ][ ][ ][ ][k][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][k][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][k][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][k][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[k][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]

[ ][ ][ ][ ][ ][ ][ ][ ][c][c][c][c][c][c][c][k]
[ ][ ][ ][ ][c][c][c][c][k][c][c][c][c][c][c][c]
[ ][ ][c][c][k][c][c][c][c][ ][ ][ ][ ][ ][ ][ ]
[ ][c][k][c][c][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[c][k][c][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[c][c][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
[k][c][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]

An ellipse follows:

sx, sy : semiaxis lengths x, y
cx, cy : center coordinates x, y
 x,  y : coordinates of a point

sx^2 * (y - cy)^2 + sy^2 * (x - cx)^2 = sx^2 * sy^2 -> CONSTANT

To draw a quarter of a ellipse with knots:

We're going to operate in a quadrant made up of these points:

f : FROM, point from where we start building
t : TO, point towards where we start building
c : CENTER, point that represents the center of the elliptic curve (in the middle of the foci)
a : ANTICENTER, point of the quadrant opposite to the center
. : a repetition of tiles that doesn't exceed reach

[a]...[t]
...   ...
[f]...[c]

Take from and vary it by 1 in the opposite direction from the center, making it one point further from the center. We'll call this the REFERENCE point.

r : REFERENCE point

[ ][a]...[t]
......   ...
[r][f]...[c]

We calculate sqr(sx) * sqr(y - cy) + sqr(sy) * sqr(x - cx) of the REFERENCE

Keep checking the value of sqr(sx) * sqr(y - cy) + sqr(sy) * sqr(x - cx) for every point from FROM to ANTICENTER

If it's more than the reach of the knot, put a new knot and continue.

k : knot

[ ][a][ ]...[t]
......   ...
[ ][k][ ]...[ ]
......   ...
[r][f][ ]...[c]

If sqr(sx) * sqr(y - cy) + sqr(sy) * sqr(x - cx) exceeds the one calculated for REFERENCE, we move it in the other axis towards the CENTER and keep moving in that direction and checking sqr(sx) * sqr(y - cy) + sqr(sy) * sqr(x - cx) until it doesn't exceed the one calculated for REFERENCE anymore.

[ ][a]...[ ]...[t]
......   ...   ...
[ ][ ]...[k]...[ ]
......   ...   ...
[r][f]...[ ]...[c]

If moving it more would put it out of reach from the previous knot, we move it in the other axis towards the center so the sqr(sx) * sqr(y - cy) + sqr(sy) * sqr(x - cx) doesn't exceed that of REFERENCE anymore.

[ ][a]...[ ]...[t]
......   ...   ...
[ ][ ]...[ ]...[!]
[ ][ ]...[ ]...[ ]
......   ...   ...
[ ][ ]...[k]...[ ]
......   ...   ...
[r][f]...[ ]...[c]

------------------

[ ][a]...[ ]...[t]
......   ...   ...
[ ][ ]...[ ]...[ ]
[ ][ ]...[ ]...[k]
......   ...   ...
[ ][ ]...[k]...[ ]
......   ...   ...
[r][f]...[ ]...[c]

We repeat this process until the tile we're testing is both within reach of the previous knot and TO.

