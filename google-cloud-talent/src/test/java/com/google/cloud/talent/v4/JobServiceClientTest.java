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
package com.google.cloud.talent.v4;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class JobServiceClientTest {
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private JobServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockTenantService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTest() {
    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");
    CompanyName company = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");
    String requisitionId = "requisitionId980224926";
    String title = "title110371416";
    String description = "description-1724546052";
    String department = "department848184146";
    String incentives = "incentives-1262874520";
    String languageCode = "languageCode-412800396";
    int promotionValue = 353413845;
    String qualifications = "qualifications1903501412";
    String responsibilities = "responsibilities-926952660";
    String companyDisplayName = "companyDisplayName1982424170";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name.toString())
            .setCompany(company.toString())
            .setRequisitionId(requisitionId)
            .setTitle(title)
            .setDescription(description)
            .setDepartment(department)
            .setIncentives(incentives)
            .setLanguageCode(languageCode)
            .setPromotionValue(promotionValue)
            .setQualifications(qualifications)
            .setResponsibilities(responsibilities)
            .setCompanyDisplayName(companyDisplayName)
            .build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = (CreateJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Job job = Job.newBuilder().build();

      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateJobsTest() throws Exception {
    BatchCreateJobsResponse expectedResponse = BatchCreateJobsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    BatchCreateJobsResponse actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateJobsRequest actualRequest = (BatchCreateJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<Job> jobs = new ArrayList<>();

      client.batchCreateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTest() {
    JobName name2 = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");
    CompanyName company = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");
    String requisitionId = "requisitionId980224926";
    String title = "title110371416";
    String description = "description-1724546052";
    String department = "department848184146";
    String incentives = "incentives-1262874520";
    String languageCode = "languageCode-412800396";
    int promotionValue = 353413845;
    String qualifications = "qualifications1903501412";
    String responsibilities = "responsibilities-926952660";
    String companyDisplayName = "companyDisplayName1982424170";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setCompany(company.toString())
            .setRequisitionId(requisitionId)
            .setTitle(title)
            .setDescription(description)
            .setDepartment(department)
            .setIncentives(incentives)
            .setLanguageCode(languageCode)
            .setPromotionValue(promotionValue)
            .setQualifications(qualifications)
            .setResponsibilities(responsibilities)
            .setCompanyDisplayName(companyDisplayName)
            .build();
    mockJobService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = (GetJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobTest() {
    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");
    CompanyName company = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");
    String requisitionId = "requisitionId980224926";
    String title = "title110371416";
    String description = "description-1724546052";
    String department = "department848184146";
    String incentives = "incentives-1262874520";
    String languageCode = "languageCode-412800396";
    int promotionValue = 353413845;
    String qualifications = "qualifications1903501412";
    String responsibilities = "responsibilities-926952660";
    String companyDisplayName = "companyDisplayName1982424170";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name.toString())
            .setCompany(company.toString())
            .setRequisitionId(requisitionId)
            .setTitle(title)
            .setDescription(description)
            .setDepartment(department)
            .setIncentives(incentives)
            .setLanguageCode(languageCode)
            .setPromotionValue(promotionValue)
            .setQualifications(qualifications)
            .setResponsibilities(responsibilities)
            .setCompanyDisplayName(companyDisplayName)
            .build();
    mockJobService.addResponse(expectedResponse);

    Job job = Job.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Job actualResponse = client.updateJob(job, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = (UpdateJobRequest) actualRequests.get(0);

    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      Job job = Job.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateJob(job, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateJobsTest() throws Exception {
    BatchUpdateJobsResponse expectedResponse = BatchUpdateJobsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    BatchUpdateJobsResponse actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateJobsRequest actualRequest = (BatchUpdateJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<Job> jobs = new ArrayList<>();

      client.batchUpdateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = (DeleteJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteJobsTest() throws Exception {
    BatchDeleteJobsResponse expectedResponse = BatchDeleteJobsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<String> formattedNames = new ArrayList<>();

    BatchDeleteJobsResponse actualResponse =
        client.batchDeleteJobsAsync(parent, formattedNames).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = (BatchDeleteJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(formattedNames, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<String> formattedNames = new ArrayList<>();

      client.batchDeleteJobsAsync(parent, formattedNames).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsTest() {
    String nextPageToken = "";
    Job jobsElement = Job.newBuilder().build();
    List<Job> jobs = Arrays.asList(jobsElement);
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = (ListJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      String filter = "filter-1274492040";

      client.listJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchJobsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    int totalSize = 705419236;
    int broadenedQueryJobsCount = 1432104658;
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .setBroadenedQueryJobsCount(broadenedQueryJobsCount)
            .build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(parent.toString())
            .setRequestMetadata(requestMetadata)
            .build();

    SearchJobsResponse actualResponse = client.searchJobs(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = (SearchJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(requestMetadata, actualRequest.getRequestMetadata());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(parent.toString())
              .setRequestMetadata(requestMetadata)
              .build();

      client.searchJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchJobsForAlertTest() {
    String nextPageToken = "nextPageToken-1530815211";
    int totalSize = 705419236;
    int broadenedQueryJobsCount = 1432104658;
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .setBroadenedQueryJobsCount(broadenedQueryJobsCount)
            .build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(parent.toString())
            .setRequestMetadata(requestMetadata)
            .build();

    SearchJobsResponse actualResponse = client.searchJobsForAlert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = (SearchJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(requestMetadata, actualRequest.getRequestMetadata());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchJobsForAlertExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(parent.toString())
              .setRequestMetadata(requestMetadata)
              .build();

      client.searchJobsForAlert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
