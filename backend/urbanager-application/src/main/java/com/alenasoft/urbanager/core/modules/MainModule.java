package com.alenasoft.urbanager.core.modules;

import com.alenasoft.urbanager.UrbanagerConf;
import com.alenasoft.urbanager.resources.example.service.Implementation.PrimeServImpl;
import com.alenasoft.urbanager.resources.example.service.Interfaces.ExampleService;
import com.alenasoft.urbanager.resources.example.service.Implementation.ExampleServiceImpl;
import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeServ;
import com.alenasoft.urbanager.resources.example.service.Interfaces.SumService;
import com.alenasoft.urbanager.resources.example.service.Implementation.SumServiceImpl;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

/**
 * This class should define the main bindings for dependency injection.
 *
 * @author Luis Roberto Perez
 * @since 20-05-17
 */
public class MainModule extends DropwizardAwareModule<UrbanagerConf> {
  @Override
  protected void configure() {
    bind(ExampleService.class).to(ExampleServiceImpl.class);
    bind(SumService.class).to(SumServiceImpl.class);
    bind(PrimeServ.class).to(PrimeServImpl.class);
  }
}
