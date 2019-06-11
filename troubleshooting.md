# Camera movements are limited
If camera rotations are limited, then most probably `Robot` fails to center the cursor. 
That's because `moveMouse` does not work on Wayland. The only solution is to switch to
Xorg.