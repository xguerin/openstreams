/*
 * Copyright 2021 IBM Corporation
 * Copyright 2023 Xenogenics
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.streams.controller.crds.jobs;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.streams.controller.bundle.EBundlePullPolicy;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize
public class BundleSpec implements KubernetesResource {

  @Getter @Setter private String name;
  @Getter @Setter private EBundlePullPolicy pullPolicy;
  @Getter @Setter private GithubSourceSpec github;
  @Getter @Setter private FileSourceSpec file;
  @Getter @Setter private HttpSourceSpec http;

  public BundleSpec() {
    this.pullPolicy = EBundlePullPolicy.IfNotPresent;
  }

  public BundleSpec(BundleSpec spec) {
    this.name = spec.name;
    this.pullPolicy = spec.pullPolicy;
    this.github = spec.github != null ? new GithubSourceSpec(spec.github) : null;
    this.file = spec.file != null ? new FileSourceSpec(spec.file) : null;
    this.http = spec.http != null ? new HttpSourceSpec(spec.http) : null;
  }
}
