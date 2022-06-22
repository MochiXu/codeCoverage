

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


public class BackendConfig {

    private ServerConfig server;
    private GatewayConfig gateway;
    private ControllerConfig controller;
    private FptConfig fpt;
    private PalmConfig palm;
    private boolean useInternalBarcode;
    private boolean useScheduler;
    private boolean useStorageFailOver;
    private boolean useFileCache;
    private String dcName;
    private int weedDiffRackCount;
    private boolean useOpenCV;
    private boolean useRedisCluster;

    public ServerConfig getServer() {
        return server;
    }

    public void setServer(ServerConfig server) {
        this.server = server;
    }

    public GatewayConfig getGateway() {
        return gateway;
    }

    public void setGateway(GatewayConfig gateway) {
        this.gateway = gateway;
    }

    public ControllerConfig getController() {
        return controller;
    }

    public void setController(ControllerConfig controller) {
        this.controller = controller;
    }

    public FptConfig getFpt() {
        return fpt;
    }

    public void setFpt(FptConfig fpt) {
        this.fpt = fpt;
    }

    public PalmConfig getPalm() { return palm; }

    public void setPalm(PalmConfig palm) { this.palm = palm; }

    public boolean isUseInternalBarcode() {
        return useInternalBarcode;
    }

    public void setUseInternalBarcode(boolean useInternalBarcode) {
        this.useInternalBarcode = useInternalBarcode;
    }

    public boolean isUseScheduler() {
        return useScheduler;
    }

    public void setUseScheduler(boolean useScheduler) {
        this.useScheduler = useScheduler;
    }

    public boolean isUseStorageFailOver() { return useStorageFailOver; }

    public void setUseStorageFailOver(boolean useStorageFailOver) {
        this.useStorageFailOver = useStorageFailOver;
    }

    public boolean isUseFileCache() { return useFileCache; }

    public void setUseFileCache(boolean useFileCache) {
        this.useFileCache = useFileCache;
    }

    public String getDcName() { return dcName; }

    public void setDcName(String dcName) { this.dcName = dcName; }

    public int getWeedDiffRackCount() { return weedDiffRackCount; }

    public void setWeedDiffRackCount(int weedDiffRackCount) { this.weedDiffRackCount = weedDiffRackCount; }

    public boolean isUseOpenCV() {
        return useOpenCV;
    }

    public void setUseOpenCV(boolean useOpenCV) {
        this.useOpenCV = useOpenCV;
    }

    public static class Segments {
        private final List<Integer> tenprint;
        private final List<Integer> latent;

        public Segments(List<Integer> tenprint, List<Integer> latent) {
            this.tenprint = tenprint;
            this.latent = latent;
        }

        public List<Integer> getTenprint() {
            return tenprint;
        }

        public List<Integer> getLatent() {
            return latent;
        }

        @Override
        public String toString() {
            return String.format("{tenprint: %s, latent: %s}", tenprint, latent);
        }
    }

    public static class SegmentMemSize {

    }

    public static class MatchingServerConfig {
        private String host;
        // only used in docker-compose
        private String dataHost;
        private int port;
        private int dataServerPort;
        private String index;
        private String cluster;
        private Map<String, Segments> segments;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        // only used in docker-compose
        public String getDataHost() {
            return dataHost;
        }

        public void setDataHost(String dataHost) {
            this.dataHost = dataHost;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public int getDataServerPort() {
            return dataServerPort;
        }

        public void setDataServerPort(int dataServerPort) {
            this.dataServerPort = dataServerPort;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }





        public Map<String, Segments> getSegments() {
            return segments;
        }

        public void setSegmentsFromSegmentMap(Map<String, Segments> segments) {
            this.segments = segments;
        }

        public void setSegments(Map<String, Object> segments) {
            this.segments = new ConcurrentHashMap<>();
            segments.forEach((k, v) -> {
                HashMap<String, List<Integer>> value = (HashMap<String, List<Integer>>) v;
                this.segments.put(k, new Segments(new CopyOnWriteArrayList<>(value.get("tenprint")),
                        new CopyOnWriteArrayList<>(value.get("latent"))));
            });
        }




        public String getCluster() {
            return cluster;
        }

        public void setCluster(String cluster) {
            this.cluster = cluster;
        }
    }

    public static class ServerConfig {
        private String coreRedis;
        private List<String> coreRedisSentinels;
        private String coreRedisPassword;
        private String taskRedis;
        private List<String> taskRedisSentinels;
        private String taskRedisPassword;
        private String cacheRedis;
        private String weed;
        private String cassandra;
        private List<String> cassandraHosts;
        private String cassandraUser;
        private String cassandraPassword;
        private String gateway;
        private List<String> controllers;
        private String controllerPrometheus;
        private String gatewayPrometheus;
        private List<String> extractionServers;
        private List<String> extractionFullPalmServers;
        private List<String> imageProcessingServers;
        private List<MatchingServerConfig> matchingServers;
        private Map<String, String> dataServers;
        private List<String> extractionTenprintServers;
        private List<String> extractionLatentServers;
        private List<String> confirmationServers;
        private List<String> fptServers;
        private List<String> fptWinServers;
        private String taskResultServer;
        private String openAPIServer;
        private String consulServer;
        private int sshPort;

        public String getCoreRedis() {
            return coreRedis;
        }

        public void setCoreRedis(String coreRedis) {
            this.coreRedis = coreRedis;
        }

        public List<String> getCoreRedisSentinels() {
            return coreRedisSentinels;
        }

        public void setCoreRedisSentinels(List<String> coreRedisSentinels) {
            this.coreRedisSentinels = coreRedisSentinels;
        }

        public String getTaskRedis() {
            return taskRedis;
        }

        public void setTaskRedis(String taskRedis) {
            this.taskRedis = taskRedis;
        }

        public String getCacheRedis() { return cacheRedis; }

        public void setCacheRedis(String cacheRedis) { this.cacheRedis = cacheRedis; }

        public List<String> getTaskRedisSentinels() {
            return taskRedisSentinels;
        }

        public void setTaskRedisSentinels(List<String> taskRedisSentinels) {
            this.taskRedisSentinels = taskRedisSentinels;
        }

        public String getWeed() {
            return weed;
        }

        public void setWeed(String weed) {
            this.weed = weed;
        }

        public String getCassandra() {
            return cassandra;
        }

        public void setCassandra(String cassandra) {
            this.cassandra = cassandra;
        }

        public List<String> getCassandraHosts() { return cassandraHosts; }

        public void setCassandraHosts(List<String> cassandraHosts) {
            this.cassandraHosts = cassandraHosts;
        }

        public String getCassandraUser() {
            return cassandraUser;
        }

        public void setCassandraUser(String cassandraUser) {
            this.cassandraUser = cassandraUser;
        }

        public String getCassandraPassword() {
            return cassandraPassword;
        }

        public void setCassandraPassword(String cassandraPassword) {
            this.cassandraPassword = cassandraPassword;
        }

        public List<String> getExtractionServers() {
            return extractionServers;
        }

        public void setExtractionServers(List<String> extractionServers) {
            this.extractionServers = extractionServers;
        }

        public List<String> getExtractionFullPalmServers() {
            return extractionFullPalmServers;
        }

        public void setExtractionFullPalmServers(List<String> extractionFullPalmServers) {
            this.extractionFullPalmServers = extractionFullPalmServers;
        }

        public List<MatchingServerConfig> getMatchingServers() {
            return matchingServers;
        }

        public void setMatchingServers(List<MatchingServerConfig> matchingServers) {
            this.matchingServers = matchingServers;
        }

        public Map<String, String> getDataServers() {
            return dataServers;
        }

        public void setDataServers(Map<String, Object> dataServers) {
            this.dataServers = new HashMap<>();
            dataServers.forEach((k, v) -> this.dataServers.put(k, (String) v));
        }

        public List<String> getExtractionTenprintServers() {
            return extractionTenprintServers;
        }

        public void setExtractionTenprintServers(List<String> extractionTenprintServers) {
            this.extractionTenprintServers = extractionTenprintServers;
        }

        public List<String> getExtractionLatentServers() {
            return extractionLatentServers;
        }

        public void setExtractionLatentServers(List<String> extractionLatentServers) {
            this.extractionLatentServers = extractionLatentServers;
        }

        public List<String> getFptServers() {
            return fptServers;
        }

        public void setFptServers(List<String> fptServers) {
            this.fptServers = fptServers;
        }

        public List<String> getFptWinServers() {
            return fptWinServers;
        }

        public void setFptWinServers(List<String> fptWinServers) {
            this.fptWinServers = fptWinServers;
        }

        public List<String> getConfirmationServers() {
            return confirmationServers;
        }

        public void setConfirmationServers(List<String> confirmationServers) {
            this.confirmationServers = confirmationServers;
        }

        public String getConsulServer() {
            return consulServer;
        }

        public void setConsulServer(String consulServer) {
            this.consulServer = consulServer;
        }

        public String getGateway() {
            return gateway;
        }

        public void setGateway(String gateway) {
            this.gateway = gateway;
        }

        public String getGatewayPrometheus() {
            return gatewayPrometheus;
        }

        public void setGatewayPrometheus(String gatewayPrometheus) {
            this.gatewayPrometheus = gatewayPrometheus;
        }

        public List<String> getControllers() {
            return controllers;
        }

        public void setControllers(List<String> controllers) {
            this.controllers = controllers;
        }

        public String getControllerPrometheus() {
            return controllerPrometheus;
        }

        public void setControllerPrometheus(String controllerPrometheus) {
            this.controllerPrometheus = controllerPrometheus;
        }

        public String getTaskResultServer() {
            return taskResultServer;
        }

        public void setTaskResultServer(String taskResultServer2) {
            this.taskResultServer = taskResultServer2;
        }

        public String getOpenAPIServer() {
            return openAPIServer;
        }

        public void setOpenAPIServer(String openAPIServer) {
            this.openAPIServer = openAPIServer;
        }

        public String getCoreRedisPassword() {
            return coreRedisPassword;
        }

        public void setCoreRedisPassword(String coreRedisPassword) {
            this.coreRedisPassword = coreRedisPassword;
        }

        public String getTaskRedisPassword() {
            return taskRedisPassword;
        }

        public void setTaskRedisPassword(String taskRedisPassword) {
            this.taskRedisPassword = taskRedisPassword;
        }

        public void setImageProcessingServers(List<String> imageProcessingServers) {
            this.imageProcessingServers = imageProcessingServers;
        }

        public List<String> getImageProcessingServers() {
            return imageProcessingServers;
        }

    }

    public static class GatewayConfig {
        private int minTenprintFinger;
        private int maxTenprintFinger;
        private int minLatentFinger;
        private int maxLatentFinger;
        private int addTaskPriority;
        private boolean mirrorMatch;
        private boolean advancedMixed;
        private double ttScoreThreshold;
        private double patrolTtScoreThreshold;
        private List<String> mirrorPrefixes;
        private int maxPendingTasks;
        private boolean wcsyFrontend;
        private boolean matchConfirmation;
        private boolean ttLrMatch;
        private int maxMessageSize;
        private int numThreads;
        private int batchUpdateSize;

        public int getBatchUpdateSize() {
            return batchUpdateSize;
        }

        public void setBatchUpdateSize(int batchUpdateSize) {
            this.batchUpdateSize = batchUpdateSize;
        }

        public int getMinTenprintFinger() {
            return minTenprintFinger;
        }

        public void setMinTenprintFinger(int minTenprintFinger) {
            this.minTenprintFinger = minTenprintFinger;
        }

        public int getMaxTenprintFinger() {
            return maxTenprintFinger;
        }

        public void setMaxTenprintFinger(int maxTenprintFinger) {
            this.maxTenprintFinger = maxTenprintFinger;
        }

        public int getMinLatentFinger() {
            return minLatentFinger;
        }

        public void setMinLatentFinger(int minLatentFinger) {
            this.minLatentFinger = minLatentFinger;
        }

        public int getMaxLatentFinger() {
            return maxLatentFinger;
        }

        public void setMaxLatentFinger(int maxLatentFinger) {
            this.maxLatentFinger = maxLatentFinger;
        }

        public int getAddTaskPriority() {
            return addTaskPriority;
        }

        public void setAddTaskPriority(int addTaskPriority) {
            this.addTaskPriority = addTaskPriority;
        }

        public boolean isMirrorMatch() {
            return mirrorMatch;
        }

        public void setMirrorMatch(boolean mirrorMatch) {
            this.mirrorMatch = mirrorMatch;
        }

        public boolean isAdvancedMixed() {
            return advancedMixed;
        }

        public void setAdvancedMixed(boolean advancedMixed) {
            this.advancedMixed = advancedMixed;
        }

        public double getTtScoreThreshold() {
            return ttScoreThreshold;
        }

        public void setTtScoreThreshold(double ttScoreThreshold) {
            this.ttScoreThreshold = ttScoreThreshold;
        }

        public void setPatrolTtScoreThreshold(double patrolTtScoreThreshold) { this.patrolTtScoreThreshold = patrolTtScoreThreshold; }

        public double getPatrolTtScoreThreshold() { return patrolTtScoreThreshold; }

        public List<String> getMirrorPrefixes() {
            return mirrorPrefixes;
        }

        public void setMirrorPrefixes(List<String> mirrorPrefixes) {
            this.mirrorPrefixes = mirrorPrefixes;
        }

        public int getMaxPendingTasks() {
            return maxPendingTasks;
        }

        public void setMaxPendingTasks(int maxPendingTasks) {
            this.maxPendingTasks = maxPendingTasks;
        }

        public boolean isWcsyFrontend() {
            return wcsyFrontend;
        }

        public void setWcsyFrontend(boolean wcsyFrontend) {
            this.wcsyFrontend = wcsyFrontend;
        }

        public boolean isMatchConfirmation() {
            return matchConfirmation;
        }

        public void setMatchConfirmation(boolean matchConfirmation) {
            this.matchConfirmation = matchConfirmation;
        }

        public boolean isTtLrMatch() {
            return ttLrMatch;
        }

        public void setTtLrMatch(boolean ttLrMatch) {
            this.ttLrMatch = ttLrMatch;
        }

        public int getMaxMessageSize() {
            return maxMessageSize;
        }

        public void setMaxMessageSize(int maxMessageSize) {
            this.maxMessageSize = maxMessageSize;
        }

        public int getNumThreads() {
            return numThreads;
        }

        public void setNumThreads(int numThreads) {
            this.numThreads = numThreads;
        }
    }

    public static class ControllerConfig {
        private int numUpdateThreads;
        private int numMatchThreads;
        private boolean autoPlacement;
        private boolean useIPForIndex;
        private int index;
        private Map<String, Segments> segments;
        private List<String> clusterRules;
        private Map<String, SegmentMemSize> segmentMemSizes;
        private int tenprintSegmentSize;
        private int tenprintPalmSegmentSize;
        private int tenprintFullPalmSegmentSize;
        private int latentSegmentSize;
        private int chunkSize;
        private int maxParallelSegments;
        private int semaphoreNumber;
        private int maxParallelSegmentsPerDataServer;
        private int maxMatchingQueue;
        private int maxMatchingServerQueue;
        private int matchingTaskTimeoutDuration;
        private int matchingTaskTimeoutRestartCount;

        private boolean tlScoreNormalization;
        private boolean ltScoreNormalization;
        private boolean ttScoreNormalization;

        private double ltNormalizeTop1W;
        private double ltNormalizeOffsetW;
        private double ltNormalizeIntercept;
        private int ltNormalizeTopK;
        private double ltNormalizeThreshold;
        private double ltNormalizeThresholdV5;
        private double ltNormalizeOffset;

        private double ttNormalizeW;
        private double ttNormalizeR;
        private double ttNormalizeB;

        private boolean tlFingerScoreNormalization;
        private int tlFingerScoreNormalizationTopk;
        private int tlFingerScoreNormalizationTopkMean;

        private double tlNormalizeTop1W;
        private double tlNormalizeOffsetW;
        private double tlNormalizeIntercept;
        private int tlNormalizeTopK;
        private double tlNormalizeThreshold;
        private double tlNormalizeOffset;

        private boolean dynamicalNormalization;   // normalization will depend on top1-topK offset

        // rescale auto / mixed / expert_only
        private boolean useRescale;
        private double autoRescaleK;
        private double autoRescaleB;
        private double mixedRescaleK;
        private double mixedRescaleB;
        private double expertOnlyRescaleK;
        private double expertOnlyRescaleB;

        private int extractionDatabaseQueueLimit;
        private int extractionDatabaseTimeout;

        private boolean rerunTask;
        private int fusionTopk;
        private boolean createTable;
        private int expectServerNum;
        private boolean segmentRebalance;
        private boolean defaultOnly; // used for test
        private boolean autoBatchUpdate;
        private int updateCheckDuration;
        private boolean buildAllSegments;
        private boolean buildNonValidSegments;
        private boolean useJ2kForExtraction;

        private int sshPort;
        private int waitMatchingServerTimeout;

        private int opPort;
        private boolean importMode;
        private boolean skipPalmExtraction;
        private List<String> ignoreDBList;
        private List<String> buildSegmentsDBList;
        private int maxTenprintSegments;
        private boolean confirmationService;
        private boolean atLeast200Candidate;
        private boolean useConsul;
        private String k8sNamespace;
        private String k8sDeployName;
        private boolean useFullPalm;
        private boolean buildFullPalmOnly;
        private String autoRebuildSegments;

        public double getLtNormalizeThresholdV5() {
            return ltNormalizeThresholdV5;
        }

        public void setLtNormalizeThresholdV5(double ltNormalizeThresholdV5) {
            this.ltNormalizeThresholdV5 = ltNormalizeThresholdV5;
        }

        public boolean isAtLeast200Candidate() {
            return atLeast200Candidate;
        }

        public void setAtLeast200Candidate(boolean atLeast200Candidate) {
            this.atLeast200Candidate = atLeast200Candidate;
        }

        public String getAutoRebuildSegments() {
            return autoRebuildSegments;
        }

        public void setAutoRebuildSegments(String autoRebuildSegments) {
            this.autoRebuildSegments = autoRebuildSegments;
        }

        public int getNumUpdateThreads() {
            return numUpdateThreads;
        }

        public void setNumUpdateThreads(int numUpdateThreads) {
            this.numUpdateThreads = numUpdateThreads;
        }

        public int getNumMatchThreads() {
            return numMatchThreads;
        }

        public void setNumMatchThreads(int numMatchThreads) {
            this.numMatchThreads = numMatchThreads;
        }

        public boolean isAutoPlacement() {
            return autoPlacement;
        }

        public void setAutoPlacement(boolean autoPlacement) {
            this.autoPlacement = autoPlacement;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getTenprintSegmentSize() {
            return tenprintSegmentSize;
        }

        public void setTenprintSegmentSize(int tenprintSegmentSize) {
            this.tenprintSegmentSize = tenprintSegmentSize;
        }

        public int getTenprintPalmSegmentSize() {
            return tenprintPalmSegmentSize;
        }

        public void setTenprintPalmSegmentSize(int tenprintPalmSegmentSize) {
            this.tenprintPalmSegmentSize = tenprintPalmSegmentSize;
        }

        public int getTenprintFullPalmSegmentSize() {
            return tenprintFullPalmSegmentSize;
        }

        public void setTenprintFullPalmSegmentSize(int tenprintFullPalmSegmentSize) {
            this.tenprintFullPalmSegmentSize = tenprintFullPalmSegmentSize;
        }


        public int getLatentSegmentSize() {
            return latentSegmentSize;
        }

        public void setLatentSegmentSize(int latentSegmentSize) {
            this.latentSegmentSize = latentSegmentSize;
        }

        public int getChunkSize() {
            return chunkSize;
        }

        public void setChunkSize(int chunkSize) {
            this.chunkSize = chunkSize;
        }

        public int getMaxParallelSegments() {
            return maxParallelSegments;
        }

        public void setMaxParallelSegments(int maxParallelSegments) {
            this.maxParallelSegments = maxParallelSegments;
        }

        public int getSemaphoreNumber() { return semaphoreNumber; }

        public void setSemaphoreNumber(int semaphoreNumber) {
            this.semaphoreNumber = semaphoreNumber;
        }

        public int getMaxMatchingQueue() {
            return maxMatchingQueue;
        }

        public void setMaxMatchingQueue(int maxMatchingQueue) {
            this.maxMatchingQueue = maxMatchingQueue;
        }

        public int getMaxMatchingServerQueue() {
            return maxMatchingServerQueue;
        }

        public void setMaxMatchingServerQueue(int maxMatchingServerQueue) {
            this.maxMatchingServerQueue = maxMatchingServerQueue;
        }

        public int getMatchingTaskTimeoutDuration() {
            return this.matchingTaskTimeoutDuration;
        }

        public void setMatchingTaskTimeoutDuration(int matchingTaskTimeoutDuration) {
            this.matchingTaskTimeoutDuration = matchingTaskTimeoutDuration;
        }

        public int getMatchingTaskTimeoutRestartCount() {
            return this.matchingTaskTimeoutRestartCount;
        }

        public void setMatchingTaskTimeoutRestartCount(int matchingTaskTimeoutRestartCount) {
            this.matchingTaskTimeoutRestartCount = matchingTaskTimeoutRestartCount;
        }

        public boolean isTlScoreNormalization() {
            return tlScoreNormalization;
        }

        public void setTlScoreNormalization(boolean tlScoreNormalization) {
            this.tlScoreNormalization = tlScoreNormalization;
        }

        public boolean isLtScoreNormalization() {
            return ltScoreNormalization;
        }

        public void setLtScoreNormalization(boolean ltScoreNormalization) {
            this.ltScoreNormalization = ltScoreNormalization;
        }

        public boolean isTtScoreNormalization() {
            return this.ttScoreNormalization;
        }

        public void setTtScoreNormalization(boolean ttScoreNormalization) {
            this.ttScoreNormalization = ttScoreNormalization;
        }

        public boolean isDynamicalNormalization(){ return this.dynamicalNormalization; }

        public void setDynamicalNormalization(boolean dynamicalNormalization) {
            this.dynamicalNormalization = dynamicalNormalization;
        }

        public double getLtNormalizeTop1W(){
            return ltNormalizeTop1W;
        }

        public void setLtNormalizeTop1W(double ltNormalizeTop1W){
            this.ltNormalizeTop1W = ltNormalizeTop1W;
        }

        public double getLtNormalizeOffsetW(){
            return ltNormalizeOffsetW;
        }

        public void setLtNormalizeOffsetW(double ltNormalizeOffsetW){
            this.ltNormalizeOffsetW = ltNormalizeOffsetW;
        }

        public double getLtNormalizeIntercept(){
            return ltNormalizeIntercept;
        }

        public void setLtNormalizeIntercept(double ltNormalizeIntercept){
            this.ltNormalizeIntercept = ltNormalizeIntercept;
        }

        public int getLtNormalizeTopK(){
            return ltNormalizeTopK;
        }

        public void setLtNormalizeTopK(int ltNormalizeTopK){
            this.ltNormalizeTopK = ltNormalizeTopK;
        }

        public double getLtNormalizeThreshold(){
            return ltNormalizeThreshold;
        }

        public void setLtNormalizeThreshold(double ltNormalizeThreshold){
            this.ltNormalizeThreshold = ltNormalizeThreshold;
        }

        public double getLtNormalizeOffset(){
            return this.ltNormalizeOffset;
        }

        public void setLtNormalizeOffset(double ltNormalizeOffset){
            this.ltNormalizeOffset = ltNormalizeOffset;
        }

        public boolean isTlFingerScoreNormalization() {
            return tlFingerScoreNormalization;
        }

        public void setTlFingerScoreNormalization(boolean tlFingerScoreNormalization) {
            this.tlFingerScoreNormalization = tlFingerScoreNormalization;
        }

        public int getTlFingerScoreNormalizationTopk() {
            return tlFingerScoreNormalizationTopk;
        }

        public void setTlFingerScoreNormalizationTopk(int tlFingerScoreNormalizationTopk) {
            this.tlFingerScoreNormalizationTopk = tlFingerScoreNormalizationTopk;
        }

        public int getTlFingerScoreNormalizationTopkMean() {
            return tlFingerScoreNormalizationTopkMean;
        }

        public void setTlFingerScoreNormalizationTopkMean(int tlFingerScoreNormalizationTopkMean) {
            this.tlFingerScoreNormalizationTopkMean = tlFingerScoreNormalizationTopkMean;
        }

        public double getTtNormalizeW(){
            return this.ttNormalizeW;
        }

        public void setTtNormalizeW(double ttNormalizeW){
            this.ttNormalizeW = ttNormalizeW;
        }

        public double getTtNormalizeR(){
            return this.ttNormalizeR;
        }

        public void setTtNormalizeR(double ttNormalizeR){
            this.ttNormalizeR = ttNormalizeR;
        }

        public double getTtNormalizeB(){
            return this.ttNormalizeB;
        }

        public void setTtNormalizeB(double ttNormalizeB){
            this.ttNormalizeB = ttNormalizeB;
        }

        public double getTlNormalizeTop1W(){
            return tlNormalizeTop1W;
        }

        public void setTlNormalizeTop1W(double tlNormalizeTop1W){
            this.tlNormalizeTop1W = tlNormalizeTop1W;
        }

        public double getTlNormalizeOffsetW(){
            return tlNormalizeOffsetW;
        }

        public void setTlNormalizeOffsetW(double tlNormalizeOffsetW){
            this.tlNormalizeOffsetW = tlNormalizeOffsetW;
        }

        public double getTlNormalizeIntercept(){
            return tlNormalizeIntercept;
        }

        public void setTlNormalizeIntercept(double tlNormalizeIntercept){
            this.tlNormalizeIntercept = tlNormalizeIntercept;
        }

        public int getTlNormalizeTopK(){
            return tlNormalizeTopK;
        }

        public void setTlNormalizeTopK(int tlNormalizeTopK){
            this.tlNormalizeTopK = tlNormalizeTopK;
        }

        public double getTlNormalizeThreshold(){
            return tlNormalizeThreshold;
        }

        public void setTlNormalizeThreshold(double tlNormalizeThreshold){
            this.tlNormalizeThreshold = tlNormalizeThreshold;
        }

        public double getTlNormalizeOffset(){
            return this.tlNormalizeOffset;
        }

        public void setTlNormalizeOffset(double tlNormalizeOffset) {
            this.tlNormalizeOffset = tlNormalizeOffset;
        }

        public boolean isUseRescale() {
            return this.useRescale;
        }

        public void setUseRescale(boolean useRescale) {
            this.useRescale = useRescale;
        }

        public double getAutoRescaleK() {
            return this.autoRescaleK;
        }

        public void setAutoRescaleK(double k) {
            this.autoRescaleK = k;
        }

        public double getAutoRescaleB() {
            return this.autoRescaleB;
        }

        public void setAutoRescaleB(double b) {
            this.autoRescaleB = b;
        }

        public double getMixedRescaleK() {
            return this.mixedRescaleK;
        }

        public void setMixedRescaleK(double k) {
            this.mixedRescaleK = k;
        }

        public double getMixedRescaleB() {
            return this.mixedRescaleB;
        }

        public void setMixedRescaleB(double b) {
            this.mixedRescaleB = b;
        }

        public double getExpertOnlyRescaleK() {
            return this.expertOnlyRescaleK;
        }

        public void setExpertOnlyRescaleK(double k) {
            this.expertOnlyRescaleK = k;
        }

        public double getExpertOnlyRescaleB() {
            return this.expertOnlyRescaleB;
        }

        public void setExpertOnlyRescaleB(double b) {
            this.expertOnlyRescaleB = b;
        }

        public int getExtractionDatabaseQueueLimit() {
            return extractionDatabaseQueueLimit;
        }

        public void setExtractionDatabaseQueueLimit(int extractionDatabaseQueueLimit) {
            this.extractionDatabaseQueueLimit = extractionDatabaseQueueLimit;
        }

        public int getExtractionDatabaseTimeout() {
            return extractionDatabaseTimeout;
        }

        public void setExtractionDatabaseTimeout(int extractionDatabaseTimeout) {
            this.extractionDatabaseTimeout = extractionDatabaseTimeout;
        }

        public boolean isRerunTask() {
            return rerunTask;
        }

        public void setRerunTask(boolean rerunTask) {
            this.rerunTask = rerunTask;
        }

        public int getFusionTopk() {
            return fusionTopk;
        }

        public void setFusionTopk(int fusionTopk) {
            this.fusionTopk = fusionTopk;
        }

        public Map<String, Segments> getSegments() {
            return segments;
        }

        public void setSegments(Map<String, Object> segments) {
            this.segments = new HashMap<>();
            segments.forEach((k, v) -> {
                HashMap<String, List<Integer>> value = (HashMap<String, List<Integer>>) v;
                this.segments.put(k, new Segments(new CopyOnWriteArrayList<>(value.get("tenprint")),
                        new CopyOnWriteArrayList<>(value.get("latent"))));
            });
        }

        public List<String> getClusterRules() {
            return clusterRules;
        }

        public void setClusterRules(List<String> clusterRules) {
            this.clusterRules = clusterRules;
        }

        public Map<String, SegmentMemSize> getSegmentMemSizes() {
            return segmentMemSizes;
        }



        public int getMaxParallelSegmentsPerDataServer() {
            return maxParallelSegmentsPerDataServer;
        }

        public void setMaxParallelSegmentsPerDataServer(int maxParallelSegmentsPerDataServer) {
            this.maxParallelSegmentsPerDataServer = maxParallelSegmentsPerDataServer;
        }

        public boolean isCreateTable() {
            return createTable;
        }

        public void setCreateTable(boolean createTable) {
            this.createTable = createTable;
        }

        public int getExpectServerNum() { return expectServerNum; }

        public void setExpectServerNum(int serverNum) { this.expectServerNum = serverNum; }

        public boolean isSegmentRebalance() { return segmentRebalance; }

        public void setSegmentRebalance(boolean segmentRebalance) {
            this.segmentRebalance = segmentRebalance;
        }

        public boolean isDefaultOnly() { return defaultOnly; }

        public void setDefaultOnly(boolean defaultOnly) { this.defaultOnly = defaultOnly; }

        public int getUpdateCheckDuration() { return updateCheckDuration; }

        public void setUpdateCheckDuration(int duration) { this.updateCheckDuration = duration; }

        public boolean isAutoBatchUpdate() { return autoBatchUpdate; }

        public void setAutoBatchUpdate(boolean autoBatchUpdate) {
            this.autoBatchUpdate = autoBatchUpdate;
        }

        public boolean isBuildNonValidSegments() { return buildNonValidSegments; }

        public void setBuildNonValidSegments(boolean buildNonValidSegments) {
            this.buildNonValidSegments = buildNonValidSegments;
        }

        public boolean isBuildAllSegments() { return buildAllSegments; }

        public void setBuildAllSegments(boolean buildAllSegments) {
            this.buildAllSegments = buildAllSegments;
        }

        public boolean isUseJ2kForExtraction() { return useJ2kForExtraction; }

        public void setUseJ2kForExtraction(boolean useJ2kForExtraction) {
            this.useJ2kForExtraction = useJ2kForExtraction;
        }

        public int getSshPort() { return sshPort; }

        public void setSshPort(int sshPort) {
            this.sshPort = sshPort;
        }

        public int getWaitMatchingServerTimeout() { return waitMatchingServerTimeout; }

        public void setWaitMatchingServerTimeout(int waitMatchingServerTimeout) {
            this.waitMatchingServerTimeout = waitMatchingServerTimeout;
        }

        public void setUseIPForIndex(boolean useIPForIndex) {
            this.useIPForIndex = useIPForIndex;
        }

        public boolean isUseIPForIndex() {
            return useIPForIndex;
        }

        public void setOpPort(int opPort) {
            this.opPort = opPort;
        }

        public int getOpPort() {
            return opPort;
        }

        public void setImportMode(boolean importMode) { this.importMode = importMode; }

        public boolean isImportMode() { return importMode; }

        public void setSkipPalmExtraction(boolean skipPalmExtraction) { this.skipPalmExtraction = skipPalmExtraction; }

        public boolean isSkipPalmExtraction() { return skipPalmExtraction; }

        public List<String> getIgnoreDBList() {
            return ignoreDBList;
        }

        public void setIgnoreDBList(List<String> ignoreDBList) {
            this.ignoreDBList = ignoreDBList;
        }

        public List<String> getBuildSegmentsDBList() {
            return buildSegmentsDBList;
        }

        public void setBuildSegmentsDBList(List<String> buildSegmentsDBList) {
            this.buildSegmentsDBList = buildSegmentsDBList;
        }

        public int getMaxTenprintSegments() { return maxTenprintSegments; }

        public void setMaxTenprintSegments(int maxTenprintSegments) {
            this.maxTenprintSegments = maxTenprintSegments;
        }

        public boolean isConfirmationService() {
            return confirmationService;
        }

        public void setConfirmationService(boolean confirmationService) {
            this.confirmationService = confirmationService;
        }

        public boolean isUseConsul(){return useConsul;}

        public void setUseConsul(boolean useConsul){
            this.useConsul = useConsul;
        }

        public String getK8sNamespace(){
            return k8sNamespace;
        }

        public void setK8sNamespace(String k8sNamespace){
            this.k8sNamespace =k8sNamespace;
        }

        public String getK8sDeployName(){
            return k8sDeployName;
        }

        public void setK8sDeployName(String k8sDeployName) {
            this.k8sDeployName = k8sDeployName;
        }

        public boolean isUseFullPalm() { return useFullPalm; }

        public void setUseFullPalm(boolean useFullPalm) { this.useFullPalm = useFullPalm; }

        public boolean isBuildFullPalmOnly() { return buildFullPalmOnly; }

        public void setBuildFullPalmOnly(boolean buildFullPalmOnly) { this.buildFullPalmOnly = buildFullPalmOnly; }
    }

    public static class FptConfig {
        private boolean useRoundRobin;
        private boolean useConsul;
        private boolean useLinux;
        private boolean useWindows;
        private boolean useK8s;

        public boolean isUseRoundRobin() {
            return useRoundRobin;
        }

        public void setUseRoundRobin(boolean useRoundRobin) {
            this.useRoundRobin = useRoundRobin;
        }

        public boolean isUseConsul() {
            return useConsul;
        }

        public void setUseConsul(boolean useConsul) {
            this.useConsul = useConsul;
        }

        public boolean isUseLinux() {
            return useLinux;
        }

        public void setUseLinux(boolean useLinux) {
            this.useLinux = useLinux;
        }

        public boolean isUseWindows() {
            return useWindows;
        }

        public void setUseWindows(boolean useWindows) {
            this.useWindows = useWindows;
        }

        public boolean isUseK8s() {
            return useK8s;
        }

        public void setUseK8s(boolean useK8s) {
            this.useK8s = useK8s;
        }
    }



    public void setUseRedisCluster(boolean useRedisCluster) { this.useRedisCluster = useRedisCluster; }

    public boolean isUseRedisCluster() { return useRedisCluster; }

    public static class PalmConfig {
        private double resizeRatio;
        private int prepSize;
        private int latentSize;
        private int tenprintSize;
        private int latentStride;
        private int tenprintStride;
        private List<Integer> latentRotationInfo;
        private int maxImageLength;
        private int maxImageSize;
        private int ttpNormalizeFactor;
        private double ttpScoreThreshold;

        public double getResizeRatio() { return resizeRatio; }

        public void setResizeRatio(double resizeRatio) { this.resizeRatio = resizeRatio; }

        public int getPrepSize() { return prepSize; }

        public void setPrepSize(int prepSize) { this.prepSize = prepSize; }

        public int getLatentSize() { return latentSize; }

        public void setLatentSize(int size) { this.latentSize = size; }

        public int getTenprintSize() { return tenprintSize; }

        public void setTenprintSize(int size) { this.tenprintSize = size; }

        public int getLatentStride() { return latentStride; }

        public void setLatentStride(int stride) { this.latentStride = stride; }

        public int getTenprintStride() { return tenprintStride; }

        public void setTenprintStride(int stride) { this.tenprintStride = stride; }

        public List<Integer> getLatentRotationInfo() { return latentRotationInfo; }

        public void setLatentRotationInfo(List<Integer> latentRotationInfo) {
            this.latentRotationInfo = latentRotationInfo;
        }

        public int getMaxImageLength() { return maxImageLength; }

        public void setMaxImageLength(int maxImageLength) { this.maxImageLength = maxImageLength; }

        public int getMaxImageSize() { return maxImageSize; }

        public void setMaxImageSize(int maxImageSize) { this.maxImageSize = maxImageSize; }

        public int getTtpNormalizeFactor() { return ttpNormalizeFactor; }

        public void setTtpNormalizeFactor(int ttpNormalizeFactor) {
            this.ttpNormalizeFactor = ttpNormalizeFactor;
        }

        public double getTtpScoreThreshold() { return ttpScoreThreshold; }

        public void setTtpScoreThreshold(double ttpScoreThreshold) {
            this.ttpScoreThreshold = ttpScoreThreshold;
        }
    }
}
