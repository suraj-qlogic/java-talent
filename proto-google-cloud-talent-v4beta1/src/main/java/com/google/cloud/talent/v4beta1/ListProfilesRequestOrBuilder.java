/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/talent/v4beta1/profile_service.proto

package com.google.cloud.talent.v4beta1;

public interface ListProfilesRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.talent.v4beta1.ListProfilesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The resource name of the tenant under which the profile is created.
   * The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   * "projects/foo/tenants/bar".
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. The resource name of the tenant under which the profile is created.
   * The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   * "projects/foo/tenants/bar".
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * The filter string specifies the profiles to be enumerated.
   * Supported operator: =, AND
   * The field(s) eligible for filtering are:
   * * `externalId`
   * * `groupId`
   * externalId and groupId cannot be specified at the same time. If both
   * externalId and groupId are provided, the API will return a bad request
   * error.
   * Sample Query:
   * * externalId = "externalId-1"
   * * groupId = "groupId-1"
   * </pre>
   *
   * <code>string filter = 5;</code>
   *
   * @return The filter.
   */
  java.lang.String getFilter();
  /**
   *
   *
   * <pre>
   * The filter string specifies the profiles to be enumerated.
   * Supported operator: =, AND
   * The field(s) eligible for filtering are:
   * * `externalId`
   * * `groupId`
   * externalId and groupId cannot be specified at the same time. If both
   * externalId and groupId are provided, the API will return a bad request
   * error.
   * Sample Query:
   * * externalId = "externalId-1"
   * * groupId = "groupId-1"
   * </pre>
   *
   * <code>string filter = 5;</code>
   *
   * @return The bytes for filter.
   */
  com.google.protobuf.ByteString getFilterBytes();

  /**
   *
   *
   * <pre>
   * The token that specifies the current offset (that is, starting result).
   * Please set the value to [ListProfilesResponse.next_page_token][google.cloud.talent.v4beta1.ListProfilesResponse.next_page_token] to
   * continue the list.
   * </pre>
   *
   * <code>string page_token = 2;</code>
   *
   * @return The pageToken.
   */
  java.lang.String getPageToken();
  /**
   *
   *
   * <pre>
   * The token that specifies the current offset (that is, starting result).
   * Please set the value to [ListProfilesResponse.next_page_token][google.cloud.talent.v4beta1.ListProfilesResponse.next_page_token] to
   * continue the list.
   * </pre>
   *
   * <code>string page_token = 2;</code>
   *
   * @return The bytes for pageToken.
   */
  com.google.protobuf.ByteString getPageTokenBytes();

  /**
   *
   *
   * <pre>
   * The maximum number of profiles to be returned, at most 100.
   * Default is 100 unless a positive number smaller than 100 is specified.
   * </pre>
   *
   * <code>int32 page_size = 3;</code>
   *
   * @return The pageSize.
   */
  int getPageSize();

  /**
   *
   *
   * <pre>
   * A field mask to specify the profile fields to be listed in response.
   * All fields are listed if it is unset.
   * Valid values are:
   * * name
   * </pre>
   *
   * <code>.google.protobuf.FieldMask read_mask = 4;</code>
   *
   * @return Whether the readMask field is set.
   */
  boolean hasReadMask();
  /**
   *
   *
   * <pre>
   * A field mask to specify the profile fields to be listed in response.
   * All fields are listed if it is unset.
   * Valid values are:
   * * name
   * </pre>
   *
   * <code>.google.protobuf.FieldMask read_mask = 4;</code>
   *
   * @return The readMask.
   */
  com.google.protobuf.FieldMask getReadMask();
  /**
   *
   *
   * <pre>
   * A field mask to specify the profile fields to be listed in response.
   * All fields are listed if it is unset.
   * Valid values are:
   * * name
   * </pre>
   *
   * <code>.google.protobuf.FieldMask read_mask = 4;</code>
   */
  com.google.protobuf.FieldMaskOrBuilder getReadMaskOrBuilder();
}
