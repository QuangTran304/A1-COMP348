second_half(Input, Output) :- length(Input, Length),
    						Temp is Length//2,
    						( (Temp*2 =:= Length)  ->  NewLength = Temp  ;  NewLength is Temp + 1 ),

    						length(NewList, NewLength),
    						append(NewList, Output, Input).



% 1. Save length into variable 'Length'
% 2. Perform 'int' division, different from 'Length/2' (float division)
% 3. 'true' when Length is Even, 'false' when Length is Odd
%
% 5. Generate an empty list with length = NewLength. We only need to care about the length of the 1st list,
%    the length of the 2nd list (Output) will be auto determined.
%
% 5. Example: Run this in console:
% 		length(List1, 3), append(List1, List2, [a,b,c,d,e,f]).
% 		Get this: List1 = [a, b, c], List2 = [d, e, f]
%
% 6. Use append() - see example above, unify the two EMPTY lists (NewList & Output) with the ORIGINAL
% 	 list (Input)