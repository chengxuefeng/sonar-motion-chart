/*
 * SonarQube Motion Chart Plugin
 * Copyright (C) 2009 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.motionchart;

import org.junit.Test;
import org.sonar.plugins.motionchart.MotionChartPlugin;
import org.sonar.plugins.motionchart.ProjectMotionChartWidget;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

public class ProjectMotionChartWidgetTest {
  @Test
  public void is_production_mode() {
    // Path to template is frequently changed in dev environments.
    // This test verifies that this dev path has not been accidentally committed.
    String path = new ProjectMotionChartWidget().getTemplatePath();
    assertThat(getClass().getResource(path)).isNotNull();
    assertThat(new File(path)).doesNotExist();
  }

  @Test
  public void has_id_and_title() {
    // well, just to get a 100% coverage :D
    ProjectMotionChartWidget widget = new ProjectMotionChartWidget();
    assertThat(widget.getId()).isNotEmpty();
    assertThat(widget.getTitle()).isNotEmpty();
  }

  @Test
  public void should_be_registered_in_plugin_extensions() {
    assertThat(new MotionChartPlugin().getExtensions()).contains(ProjectMotionChartWidget.class);
  }
}
