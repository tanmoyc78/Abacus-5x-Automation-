package com.abacus.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CompareUtility {

  public static boolean compareScreenShots(File screenShot1, File screenShot2) {
    try {
      BufferedImage image1 = ImageIO.read(screenShot1);
      BufferedImage image2 = ImageIO.read(screenShot2);
      if ((image1.getWidth() == image2.getWidth())
          && (image1.getHeight() == image2.getHeight())) {
        int width = image1.getWidth();
        int height = image1.getHeight();
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            if (image1.getRGB(x, y) != image2.getRGB(x, y)) {
              throw new Exception();
            }
          }
        }
        return true;
      } else {
        throw new Exception();
      }

    } catch (Exception e) {
      return false;
    }
  }

}
