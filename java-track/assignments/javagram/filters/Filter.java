package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public interface Filter {
	Picture process(Picture original, int m, Color mono);

}

