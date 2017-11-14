package de.tdlabs.apps.screencaster;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "screencaster")
public class ScreenCasterProperties {

  private ScreenGrabbingProperties grabbing = new ScreenGrabbingProperties();

  private ScreencastProperties screencast = new ScreencastProperties();

  @Data
  public static class ScreencastProperties {

    /**
     * Controls whether screen casting should start immediately after program start. Defaults to {@literal true}.
     */
    private boolean autoStart = true;
  }

  @Data
  public static class ScreenGrabbingProperties {

    public static final int DEFAULT_SCREEN = -1;

    public static final float DEFAULT_QUALITY = 0.7f;

    /**
     * Selects the screen to grab. {@literal -1} means default screen.
     */
    private int screenNo = DEFAULT_SCREEN;

    /**
     * Selects the default quality. Must be between {@literal 0.0} and {@literal 1.0}.
     */
    private float quality = DEFAULT_QUALITY;

    public boolean isGrabDefaultScreen() {
      return screenNo == DEFAULT_SCREEN;
    }
  }
}